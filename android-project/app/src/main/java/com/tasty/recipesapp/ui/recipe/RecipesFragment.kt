package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RecipeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        // Observe the recipe list LiveData
        viewModel.recipeList.observe(viewLifecycleOwner, Observer { recipes ->
            // Loop through the list of RecipeModels and print properties

            for (recipe in recipes) {
                Log.d("RecipeData", "Recipe ID: ${recipe.id}")
                Log.d("RecipeData", "Recipe Name: ${recipe.name}")
                Log.d("RecipeData", "Recipe Description: ${recipe.description}")
                Log.d("RecipeData", "Recipe Nutrition: ${recipe.nutrition}")
                Log.d("RecipeData", "Recipe Components: ${recipe.components}")
                Log.d("RecipeData", "Recipe Instructions: ${recipe.instructions}")
                Log.d("RecipeData", "Recipe Thumbnail URL: ${recipe.thumbnailUrl}")
                Log.d("RecipeData", "Recipe Keywords: ${recipe.keywords}")
                Log.d("RecipeData", "Recipe isPublic: ${recipe.isPublic}")
                Log.d("RecipeData", "Recipe User Email: ${recipe.userEmail}")
                Log.d("RecipeData", "Recipe Original Video URL: ${recipe.originalVideoUrl}")
                Log.d("RecipeData", "Recipe Country: ${recipe.country}")
                Log.d("RecipeData", "Recipe Number of Servings: ${recipe.numServings}")

            }

            // TODO: Update your UI with the recipe data
            // Set up a RecyclerView adapter here
        })

        // Fetch the recipe data
        viewModel.fetchRecipeData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
