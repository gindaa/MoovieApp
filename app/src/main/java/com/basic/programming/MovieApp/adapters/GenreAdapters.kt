package com.basic.programming.MovieApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.basic.programming.MovieApp.R
import com.basic.programming.MovieApp.model.Genre

class GenreAdapters(var context: Context, var arrayList: ArrayList<Genre>) :
    RecyclerView.Adapter<GenreAdapters.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_view_layout_items, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val genreItem: Genre = arrayList.get(position)
        
        holder.genre.text = genreItem.genre

        holder.genre.setOnClickListener {
            Toast.makeText(context, genreItem.genre, Toast.LENGTH_LONG).show()
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        var genre = itemView.findViewById<TextView>(R.id.title_text_view)

    }
}