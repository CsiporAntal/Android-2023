package com.tasty.recipesapp.mapping


import com.tasty.recipesapp.repository.recipe.*
import com.tasty.recipesapp.repository.recipe.model.*

fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.instructionID,
        displayText = this.displayText,
        position = this.position
    )
}

fun List<InstructionDTO>.toInstructionModelList(): List<InstructionModel> {
    return this.map { it.toModel() }
}

fun UnitDTO.toModel(): UnitModel {
    return UnitModel(
        name = this.name,
        displaySingular = this.displaySingular,
        displayPlural = this.displayPlural,
        abbreviation = this.abbreviation
    )
}

fun MeasurementDTO.toModel(): MeasurementModel {
    return MeasurementModel(
        amount = this.quantity,
        unit = this.unit.toModel()
    )
}

fun IngredientDTO.toModel(): IngredientModel {
    return IngredientModel(
        name = this.name
    )
}

fun ComponentDTO.toModel(): ComponentModel {
    return ComponentModel(
        rawText = this.rawText,
        extraComment = this.extraComment,
        ingredient = this.ingredient.toModel(),
        measurement = this.measurement.toModel(),
        position = this.position
    )
}

fun List<ComponentDTO>.toComponentModelList(): List<ComponentModel> {
    return this.map { it.toModel() }
}

fun NutritionDTO.toModel(): NutritionModel {
    return NutritionModel(
        calories = this.calories,
        protein = this.protein,
        fat = this.fat,
        carbohydrates = this.carbohydrates,
        sugar = this.sugar,
        fiber = this.fiber
    )
}

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.recipeID,
        name = this.name,
        description = this.description,
        thumbnailUrl = this.thumbnailUrl,
        keywords = this.keywords,
        isPublic = this.isPublic,
        userEmail = this.userEmail,
        originalVideoUrl = this.originalVideoUrl,
        country = this.country,
        numServings = this.numServings,
        components = this.components.toComponentModelList(),
        instructions = this.instructions.toInstructionModelList(),
        nutrition = this.nutrition?.toModel()
    )
}

fun List<RecipeDTO>.toRecipeModelList(): List<RecipeModel> {
    return this.map { it.toModel() }
}

fun RecipesDTO.toModelList(): List<RecipeModel> {
    return this.recipes.toRecipeModelList()
}
