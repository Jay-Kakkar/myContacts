package com.example.mycontacts.contactsDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [contacts::class], version = 2, exportSchema = false)
abstract class contactDatabase:RoomDatabase() {
    abstract val contactsDatabaseDao:contactsDatabaseDao
    companion object{
        //volatile means value is not cached and changes will be used by all
        @Volatile
        private var INSTANCE: contactDatabase? =null
        fun getInstance(context: Context): contactDatabase {
            synchronized(this){
                var instance= INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        contactDatabase::class.java,
                        "contact_History_Database"
                    )

                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
       }

    }
}