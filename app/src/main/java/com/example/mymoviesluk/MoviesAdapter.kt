package com.example.mymoviesluk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoviesluk.databinding.ViewMovieItemBinding

interface MovieClickedListener{
    fun onMovieClicked(movie:Movie) // Codigo Lamda => Parametro de entrada -> parametro de salida = (Movie) -> Unit
}

class MoviesAdapter (private val movies:List<Movie>,private val movieClickedListener: MovieClickedListener): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater
                .from(parent.context),
            parent
            ,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int { // = movies.size
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{movieClickedListener.onMovieClicked(movie)}
    }

    class  ViewHolder(private val binding: ViewMovieItemBinding ): RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.title.text = movie.title
            Glide.with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)
        }

    }
}