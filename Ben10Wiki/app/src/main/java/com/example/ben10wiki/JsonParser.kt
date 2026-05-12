package com.example.ben10wiki

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object JsonParser {
    fun parseAliens(context: Context): List<Alien> {
        val jsonString = try {
            context.assets.open("aliens.json").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            return emptyList()
        }

        val type = object : TypeToken<Map<String, List<AlienJson>>>() {}.type
        val map: Map<String, List<AlienJson>> = Gson().fromJson(jsonString, type)
        val shortMap: Map<String, String> = mapOf("Omniverse" to "OV","Original Series" to "OS", "Alien Force" to "AF", "Ultimate Alien" to "UA")
        val alienList = mutableListOf<Alien>()
        map.forEach { (series, alienJsonList) ->
            alienJsonList.forEach { alienJson ->
                val nameFolder = alienJson.name.replace(" ", "_")
                val iconPath = "$series/$nameFolder/${nameFolder}_icon.png"
                val shortSeries = shortMap[series] ?: "OS"
                alienList.add(
                    Alien(
                        name = alienJson.name,
                        series = shortSeries,
                        iconFileName = iconPath,
                        first_appearance = series,
                        species = alienJson.species ?: "Unknown",
                        home_world = alienJson.home_world ?: "Unknown",
                        abilities = alienJson.abilities,
                        appearance_order = alienJson.appearance_order
                    )
                )
            }
        }

        // Sort by series then by name
        return alienList.sortedWith(compareBy({ it.series }, { it.name }))
    }
}