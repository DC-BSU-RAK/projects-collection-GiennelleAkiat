package com.example.ben10wiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlienAdapter(
    private var aliens: List<Alien>,
    private val activity: AppCompatActivity
) : RecyclerView.Adapter<AlienAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardview: CardView = view.findViewById(R.id.alien_card_view)
        val icon: ImageView = view.findViewById(R.id.alienIcon)
        val name: TextView = view.findViewById(R.id.alienName)
        val series: TextView = view.findViewById(R.id.alienSeries)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alien, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alien = aliens[position]
        holder.name.text = alien.name
        holder.series.text = alien.series

        Glide.with(holder.itemView.context)
            .load("file:///android_asset/${alien.iconFileName}")
            .centerCrop()
            .into(holder.icon)

        holder.cardview.setOnClickListener {
            val intent = Intent(activity, InfoActivity::class.java).apply {
                putExtra("alien", alien)
            }
            activity.startActivity(intent)
        }
    }

    override fun getItemCount() = aliens.size

    fun updateList(newList: List<Alien>) {
        aliens = newList
        notifyDataSetChanged()
    }
}