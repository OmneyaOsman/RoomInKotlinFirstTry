package com.omni.domain.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.omni.entities.PetEntity

@Dao
interface PetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pet: PetEntity)

    @Delete
    fun delete(pet: PetEntity)

    @Delete
    fun deleteAll(pets: List<PetEntity>)

    @Query("select * from PetEntity order by name ASC")
    fun getAllPets():LiveData<List<PetEntity>>
}