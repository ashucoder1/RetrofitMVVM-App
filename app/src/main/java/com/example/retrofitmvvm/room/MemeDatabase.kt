package com.example.retrofitmvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitmvvm.model.Meme

@Database(entities = [Meme::class], version = 1)
abstract class MemeDatabase:RoomDatabase() {

    abstract fun memeDao():RoomDao

    companion object{
        private var INSTANCE:MemeDatabase?=null


        fun getDatabase(context: Context):MemeDatabase{

            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context,
                    MemeDatabase::class.java,
                    "memesDB"
                ).build()
            }

            return INSTANCE!!
        }
    }



}