package com.example.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.model.Jokes

class MemesRepository(private val apiInterface:ApiInterface ) {

    private val memesLiveData =MutableLiveData<Jokes>()

    val memes:LiveData<Jokes>
        get()=memesLiveData

    suspend fun getmemes(){
        val result=apiInterface.getJokes()
        if (result.body()!=null){
            memesLiveData.postValue(result.body())
        }
    }

}