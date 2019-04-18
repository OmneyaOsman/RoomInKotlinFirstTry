package com.omni.domain.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.omni.domain.applicationLiveData
import com.omni.domain.getApplication
import com.omni.entities.PetEntity


private const val DATABASE_NAME ="Pets_database"

val petsDatabase: PetsDatabase by lazy {
    buildDatabase(applicationLiveData.getApplication())
}

private fun buildDatabase(context: Context) =
        Room.databaseBuilder(context, PetsDatabase::class.java
                , DATABASE_NAME).build()


@Database(entities = [(PetEntity::class)], version = 1, exportSchema = false)
abstract class PetsDatabase : RoomDatabase() {
    abstract val petsDao : PetsDao

}