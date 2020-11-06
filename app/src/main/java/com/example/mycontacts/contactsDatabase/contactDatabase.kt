package com.example.mycontacts.contactsDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [contacts::class], version = 1, exportSchema = false)
abstract class contactDatabse:RoomDatabase(), contactsDatabaseDao {
    abstract val contactsDatabaseDao:contactsDatabaseDao
    companion object{
        //volatile means value is not cached and changes will be used by all
        @Volatile
        private var INSTANCE: contactDatabse? =null
        fun getInstance(context: Context): contactDatabse? {
            synchronized(this){
                var instance= INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        contactDatabse::class.java,
                        "sleep_history_database"
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