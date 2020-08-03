package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoVO

@Dao
interface VideoDao {

    @Query("SELECT * FROM videoDetails WHERE id = :movieId")
    fun getVideoById(movieId:Int):LiveData<VideoDetailVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideo(videos:VideoDetailVO)
}