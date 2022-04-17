package com.hegunhee.mydatabinding

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DiffUtil
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
        val diffCallback = Diff(this.movieList,items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.movieList.run {
            clear()
            addAll(items)
            diffResult.dispatchUpdatesTo(this@RecyclerAdapter)
        }
    }
}
private class Diff(
    private val oldList : List<Movie>,
    private val newList : List<Movie>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}

@BindingAdapter("bind:movieList")
fun setItems(recyclerView: RecyclerView, items: ArrayList<Movie>) {
    (recyclerView.adapter as RecyclerAdapter)?.run {
        setItems(items)
    }
}