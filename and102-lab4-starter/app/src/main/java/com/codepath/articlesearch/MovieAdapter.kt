package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
    override fun getItemCount() = movies.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.movieImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movieTitle)
        private val overviewTextView = itemView.findViewById<TextView>(R.id.movieDetails)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method

        override fun onClick(v: View?) {
            // Get selected article
            val movie = movies[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            val array = 5
            intent.putExtra(MOVIE_EXTRA,movie)
            context.startActivity(intent)
        }

        fun bind(Movie: Movie) {
            titleTextView.text = Movie.original_title
            overviewTextView.text = Movie.overview
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+Movie.poster_path)
                .into(mediaImageView)
        }
    }
}