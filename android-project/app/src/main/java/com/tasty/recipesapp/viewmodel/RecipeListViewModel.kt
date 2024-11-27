// RecipeListViewModel.kt
package com.tasty.recipesapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tasty.recipesapp.repository.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RecipeRepository(application.applicationContext)

    // LiveData to hold the list of RecipeModels
    private val _recipeList = MutableLiveData<List<RecipeModel>>()
    val recipeList: LiveData<List<RecipeModel>> get() = _recipeList

    // LiveData to hold the selected RecipeModel
    private val _selectedRecipe = MutableLiveData<RecipeModel>()
    val selectedRecipe: LiveData<RecipeModel> get() = _selectedRecipe

    /**
     * Fetches recipe data from the repository and updates LiveData.
     */
    fun fetchRecipeData() {
        viewModelScope.launch(Dispatchers.IO) {
            val recipes = repository.getAllRecipes()
            _recipeList.postValue(recipes)
        }
    }

    /**
     * Sets the selected recipe.
     */
    fun selectRecipe(recipe: RecipeModel) {
        _selectedRecipe.value = recipe
    }
}
