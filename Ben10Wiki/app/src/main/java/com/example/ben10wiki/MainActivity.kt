package com.example.ben10wiki

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var alienAdapter: AlienAdapter
    private lateinit var originalAliens: List<Alien>
    private var currentSortCriterion: SortCriterion = SortCriterion.APPEARANCE_ORDER
    private var isAscending = true



    enum class SortCriterion {
        APPEARANCE_ORDER, NAME
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Load aliens once
        originalAliens = JsonParser.parseAliens(this)

        // Set up adapter with a copy of the list
        alienAdapter = AlienAdapter(originalAliens.toMutableList(), this)
        recyclerView.adapter = alienAdapter

        setupSortingUI()
    }

    private fun setupSortingUI() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val sortButton = findViewById<Button>(R.id.button2)

        // Populate spinner with sorting options
        val sortOptions = arrayOf("Appearance Order", "Name")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sortOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentSortCriterion = when (position) {
                    0 -> SortCriterion.APPEARANCE_ORDER
                    1 -> SortCriterion.NAME
                    else -> SortCriterion.APPEARANCE_ORDER
                }
                applySorting()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        sortButton.setOnClickListener {
            isAscending = !isAscending
            sortButton.text = if (isAscending) "🔼" else "🔽"
            applySorting()
        }
    }

    private fun applySorting() {
        val sortedList = when (currentSortCriterion) {
            SortCriterion.APPEARANCE_ORDER -> {
                if (isAscending) originalAliens.sortedBy { it.appearance_order }
                else originalAliens.sortedByDescending { it.appearance_order }
            }
            SortCriterion.NAME -> {
                if (isAscending) originalAliens.sortedBy { it.name }
                else originalAliens.sortedByDescending { it.name }
            }
        }
        alienAdapter.updateList(sortedList)
    }
}