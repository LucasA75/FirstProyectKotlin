package com.example.mymoviesluk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mymoviesluk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recicler.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
                Movie ("Title 3", "https://loremflickr.com/320/240?lock=3"),
                Movie ("Title 3", "https://loremflickr.com/320/240?lock=4"),
                Movie ("Title 3", "https://loremflickr.com/320/240?lock=5"),
                Movie ("Title 3", "https://loremflickr.com/320/240?lock=6")
            ),
            object : MovieClickedListener{
                override fun onMovieClicked(movie: Movie) {
                    Toast.makeText(this@MainActivity,movie.title,Toast.LENGTH_SHORT).show()
                }
            }
        )

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}