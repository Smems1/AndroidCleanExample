package com.smems.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smems.data.dao.DetailsDao
import com.smems.data.dto.DetailsEntity

@Database(
    version = 1,
    entities = [DetailsEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val detailsDao: DetailsDao
}