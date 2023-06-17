package com.example.retrofitmvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitmvvm.model.Meme

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemes(memes:List<Meme>)

    @Query("SELECT * FROM memes")
    suspend fun getMemes():List<Meme>
}