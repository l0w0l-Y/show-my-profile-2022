package com.kaleksandra.technocracy.feature.data_view.di.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kaleksandra.technocracy.feature.data_view.di.data.entities.ProfileEntity

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profileEntity WHERE id = :id")
    fun getProfile(id: Int): ProfileEntity

    @Insert(entity = ProfileEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profileEntity: ProfileEntity)
}