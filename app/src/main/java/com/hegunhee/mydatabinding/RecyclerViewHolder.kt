package com.hegunhee.mydatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.mydatabinding.databinding.ItemBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    var movieList = ObservableArrayList<Movie>()

    inner class RecyclerViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.content.text = movie.context
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    fun setItems(items: ObservableArrayList<Movie>){
        movieList = items
        notifyDataSetChanged()
    }
}
@BindingAdapter("bind:movieList")
fun bindMovieList(recyclerView: RecyclerView, items : ObservableArrayList<Movie>){
    val adapter = recyclerView.adapter as RecyclerAdapter
    if(adapter != null){
        adapter.setItems(items)
    }

}
