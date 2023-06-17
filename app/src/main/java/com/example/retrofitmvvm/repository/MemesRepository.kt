package com.example.retrofitmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.model.Data
import com.example.retrofitmvvm.model.Jokes
import com.example.retrofitmvvm.model.Meme
import com.example.retrofitmvvm.room.MemeDatabase
import com.example.retrofitmvvm.utils.MyUtils

class MemesRepository(
    private val apiInterface: ApiInterface,
    private val memeDatabase: MemeDatabase,
    private val applicationContext: Context
) {

    private val memesLiveData =MutableLiveData<Jokes>()

    val memes:LiveData<Jokes>
        get()=memesLiveData

    suspend fun getmemes(){

        if (MyUtils.isInternetAvailable(applicationContext)){
            val result=apiInterface.getJokes()
            if (result.body()!=null){

                ///////////Database////////
                memeDatabase.memeDao().insertMemes(result.body()!!.data.memes)

                ///////////////////////////
                memesLiveData.postValue(result.body())

        }else{
            val memes=memeDatabase.memeDao().getMemes()

                val memeList=Jokes(Data(memes ),true)
                memesLiveData.postValue(memeList)
        }


        }
    }

}