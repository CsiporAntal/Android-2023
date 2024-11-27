// RecipeDetailFragment.kt
package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.viewmodel.RecipeListViewModel

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use the activity as the ViewModelStoreOwner to share the ViewModel between fragments
        viewModel = ViewModelProvider(requireActivity()).get(RecipeListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRecipeDetailBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the selected recipe
        viewModel.selectedRecipe.observe(viewLifecycleOwner) { recipe ->
            if (recipe != null) {
                displayRecipeDetails(recipe)
            }
        }
    }

    private fun displayRecipeDetails(recipe: RecipeModel) {
        binding.textViewRecipeName.text = recipe.name
        binding.textViewRecipeDescription.text = recipe.description
        binding.textViewServings.text = "Servings: ${recipe.numServings}"

        Glide.with(requireContext())
            .load(recipe.thumbnailUrl)
            .into(binding.imageViewThumbnail)

        // Display Ingredients
        binding.linearLayoutIngredients.removeAllViews()
        for (component in recipe.components) {
            val textView = TextView(requireContext())
            val unitName = component.measurement.unit?.name ?: ""
            textView.text = "${component.measurement.amount} $unitName ${component.ingredient.name}"
            binding.linearLayoutIngredients.addView(textView)
        }

        // Display Instructions
        binding.linearLayoutInstructions.removeAllViews()
        for (instruction in recipe.instructions) {
            val textView = TextView(requireContext())
            textView.text = "${instruction.position}. ${instruction.displayText}"
            binding.linearLayoutInstructions.addView(textView)
        }

        // Display Nutrition Information
        binding.linearLayoutNutrition.removeAllViews()
        recipe.nutrition?.let { nutrition ->
            val nutritionInfo = listOf(
                "Calories: ${nutrition.calories}",
                "Fat: ${nutrition.fat}g",
                "Protein: ${nutrition.protein}g",
                "Carbs: ${nutrition.carbohydrates}g",
                "Sugar: ${nutrition.sugar}g",
                "Fiber: ${nutrition.fiber}g"
            )
            for (info in nutritionInfo) {
                val textView = TextView(requireContext())
                textView.text = info
                binding.linearLayoutNutrition.addView(textView)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
