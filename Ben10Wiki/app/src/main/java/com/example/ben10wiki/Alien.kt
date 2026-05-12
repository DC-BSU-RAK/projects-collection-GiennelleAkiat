package com.example.ben10wiki

import java.io.Serializable


data class Alien(
    val name: String,
    val series: String,
    val iconFileName: String,   // e.g. "Heatblast/Heatblast_icon.png"
    val first_appearance: String,
    val species: String,
    val home_world: String,
    val abilities: List<String>,
    val appearance_order: Int
): Serializable
