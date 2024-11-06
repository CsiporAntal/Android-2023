package com.tasty.recipesapp.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.tasty.recipesapp.mapping.toModel
import com.tasty.recipesapp.mapping.toModelList
import com.tasty.recipesapp.repository.recipe.RecipeDTO
import com.tasty.recipesapp.repository.recipe.RecipesDTO
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import java.io.IOException

class RecipeRepository(private val context: Context) {

    companion object {
        private const val TAG = "RecipeRepository"
        private const val RECIPES_JSON_FILE = "all_recipes.json"
    }

    /**
     * Fetches all recipes from the JSON file and maps them to RecipeModel objects.
     */
    fun getAllRecipes(): List<RecipeModel> {
        return try {
            val jsonString = readJsonFromAssets(RECIPES_JSON_FILE)
            val gson = Gson()

            // Parse JSON directly as a list of RecipeDTO
            val recipesDTOList: List<RecipeDTO> = gson.fromJson(jsonString, Array<RecipeDTO>::class.java).toList()

            // Convert the list to a list of RecipeModel objects
            recipesDTOList.toModelList()
        } catch (e: IOException) {
            Log.e(TAG, "Error reading JSON file", e)
            emptyList()
        } catch (e: JsonSyntaxException) {
            Log.e(TAG, "Error parsing JSON", e)
            emptyList()
        }
    }

    fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
        return this.map { it.toModel() }
    }



    /**
     * Reads a JSON file from the assets folder and returns its content as a String.
     */
    @Throws(IOException::class)
    private fun readJsonFromAssets(filename: String): String {
        val assetManager = context.assets
        assetManager.open(filename).use { inputStream ->
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            return String(buffer, Charsets.UTF_8)
        }
    }
}
