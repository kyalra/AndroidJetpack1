package com.androidjetpack1.data.db_only

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import com.androidjetpack1.data.data_model.People
import com.androidjetpack1.data.data_net.PeopleListInfo

@Database(entities = [People::class],version = 1)
abstract class PeopleDb :RoomDatabase() {
    abstract fun peopleDao():PeopleDAO

    companion object {
        private val lock=Any()
        private const val DB_NAME ="people.db"
        private var INSTANCE:PeopleDb?=null

        fun getInstance(application: Application):PeopleDb{
            synchronized(lock){
                if (PeopleDb.INSTANCE == null){
                    PeopleDb.INSTANCE =
                            Room.databaseBuilder(application,
                                PeopleDb::class.java, PeopleDb.DB_NAME)
                                .allowMainThreadQueries()
                                .addCallback(object :RoomDatabase.Callback(){
                                    override fun onCreate(db: SupportSQLiteDatabase) {
                                        super.onCreate(db)
                                        PeopleDb.INSTANCE?.let{
                                            PeopleDb.prePopulated(it,PeopleListInfo.peopleList)
                                        }
                                    }
                                })
                                .build()
                }
                return INSTANCE!!
            }
        }

        fun prePopulated(database:PeopleDb,peopleList: List<People>){
            for (people in peopleList){
                AsyncTask.execute{database.peopleDao().insert(people)}
            }
        }
    }
}