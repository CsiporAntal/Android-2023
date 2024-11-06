package com.tasty.recipesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RecipeRepository(application.applicationContext)

    // LiveData to hold the list of RecipeModels
    private val _recipeList = MutableLiveData<List<RecipeModel>>()
    val recipeList: LiveData<List<RecipeModel>> get() = _recipeList

    /**
     * Fetches recipe data from the repository and updates LiveData.
     */
    fun fetchRecipeData() {
        viewModelScope.launch(Dispatchers.IO) {
            val recipes = repository.getAllRecipes()
            _recipeList.postValue(recipes)
        }
    }
}
