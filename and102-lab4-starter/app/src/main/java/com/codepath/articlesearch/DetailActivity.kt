package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"
//Completed
class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView
    private lateinit var LangTextView: TextView
    private lateinit var Pop: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.movieImage)
        titleTextView = findViewById(R.id.movieTitle)
        bylineTextView = findViewById(R.id.movieByline)
        abstractTextView = findViewById(R.id.movieDetails)
        LangTextView=findViewById(R.id.textView)
        Pop =findViewById(R.id.textView2)

        // TODO: Get the extra from the Intent
        val movies = intent.getSerializableExtra(MOVIE_EXTRA) as Movie
        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = movies.original_title
        bylineTextView.text = movies.overview
        abstractTextView.text = "Release date : "+movies.date
        LangTextView.text = "Original Language: "+movies.lang
        Pop.text = "Popularity: " +movies.pop

        // TODO: Load the media image
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movies.poster_path)
            .into(mediaImageView)
    }
}