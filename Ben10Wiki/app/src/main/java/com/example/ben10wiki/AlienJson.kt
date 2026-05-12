package com.example.ben10wiki

data class AlienJson(
    val name: String,
    val icon_image_file: String,
    val first_appearance: String,
    val species: String,
    val home_world: String,
    val abilities: List<String>,
    val appearance_order: Int
)
