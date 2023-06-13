package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.api.ApiUtilities
import com.example.retrofitmvvm.repository.MemesRepository
import com.example.retrofitmvvm.viewmodel.MemesViewModel
import com.example.retrofitmvvm.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {
    ///
    private lateinit var memesViewModel: MemesViewModel
    private lateinit var textView:TextView
    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository =(application as MyApplication).memesRepository

        memesViewModel=ViewModelProvider(this,MemesViewModelFactory(repository)).get(MemesViewModel::class.java)

        memesViewModel.memes.observe(this,{
            //Log.d("Ashu", "onCreate: ${it.toString()}")

            it.data.memes.iterator().forEach {meme->    //it replaced with meme
                Log.d("Ashu", "names:${meme.name}\n image:${meme.url} ")

            }
        })
    }
}