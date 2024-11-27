// RecipesFragment.kt
package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.adapter.RecipeListAdapter
import com.tasty.recipesapp.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RecipeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRecipesBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use the activity as the ViewModelStoreOwner to share the ViewModel between fragments
        viewModel = ViewModelProvider(requireActivity()).get(RecipeListViewModel::class.java)

        val recyclerView = binding.recyclerViewRecipes
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            val adapter = RecipeListAdapter(recipes) { selectedRecipe ->
                // Update the selected recipe in the ViewModel
                viewModel.selectRecipe(selectedRecipe)

                // Navigate to the RecipeDetailFragment
                val recipeDetailFragment = RecipeDetailFragment()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, recipeDetailFragment)
                    .addToBackStack(null)
                    .commit()
            }
            recyclerView.adapter = adapter
        }

        viewModel.fetchRecipeData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
