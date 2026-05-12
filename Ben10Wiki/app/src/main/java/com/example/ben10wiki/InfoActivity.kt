package com.example.ben10wiki

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InfoActivity: AppCompatActivity() {
    private lateinit var icon : ImageView
    private lateinit var name : TextView
    private lateinit var series : TextView
    private lateinit var species : TextView
    private lateinit var homeplanet : TextView
    private lateinit var abilitiesRecyclerView : RecyclerView
    private lateinit var back : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val alien = intent.getSerializableExtra("alien") as Alien
        icon = findViewById(R.id.AlienInfoIcon)
        name = findViewById(R.id.AlienName)
        series = findViewById(R.id.Series)
        species = findViewById(R.id.Species)
        homeplanet = findViewById(R.id.Homeplanet)
        abilitiesRecyclerView = findViewById(R.id.recyclerView2)
        back = findViewById(R.id.button)

        name.text=alien.name
        series.text=alien.first_appearance
        species.text="Species: ${alien.species}"
        homeplanet.text="Home Planet: ${alien.home_world}"
        Glide.with(this)
            .load("file:///android_asset/${alien.iconFileName}")
            .centerCrop()
            .into(icon)

        abilitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        abilitiesRecyclerView.adapter = AbilityAdapter(alien.abilities)

        back.setOnClickListener {
            finish()
        }

    }


}