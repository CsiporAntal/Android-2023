package com.tasty.recipesapp.repository.recipe

data class NutritionDTO(
    val calories: Int,
    val protein: Int,
    val fat: Int,
    val carbohydrates: Int,
    val sugar: Int,
    val fiber: Int
)