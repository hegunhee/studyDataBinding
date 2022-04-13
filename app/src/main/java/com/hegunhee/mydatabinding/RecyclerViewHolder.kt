package com.hegunhee.mydatabinding

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.mydatabinding.databinding.ItemBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    var movieList = ArrayList<Movie>()

    inner class RecyclerViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) = with(binding) {
            title.text = movie.title
            content.text = movie.context
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setItems(items: ArrayList<Movie>) {
        movieList = items
        notifyDataSetChanged()
    }
}

@BindingAdapter("bind:movieList")
fun setItems(recyclerView: RecyclerView, items: ArrayList<Movie>) {
    (recyclerView.adapter as RecyclerAdapter)?.run {
        setItems(items)
    }
}