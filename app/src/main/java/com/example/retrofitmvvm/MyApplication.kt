package com.example.retrofitmvvm

import android.app.Application
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.api.ApiUtilities
import com.example.retrofitmvvm.repository.MemesRepository
import com.example.retrofitmvvm.room.MemeDatabase

class MyApplication:Application() {

    lateinit var memesRepository: MemesRepository
    override fun onCreate() {
        super.onCreate()

        val apiinterface= ApiUtilities.getInstance().create(ApiInterface::class.java)

        val database =MemeDatabase.getDatabase(applicationContext)

        memesRepository=MemesRepository(apiinterface,database)
    }

}