package com.androidjetpack1.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.androidjetpack1.data.data_model.People
import com.androidjetpack1.data.data_net.PeopleListInfo
import com.androidjetpack1.data.db_only.PeopleDAO
import com.androidjetpack1.data.db_only.PeopleDb

class ContactRepo(application:Application) {

    private val peopleDAO:PeopleDAO

    init {
        val peopledatabase=PeopleDb.getInstance(application)
        peopleDAO=peopledatabase.peopleDao()
    }


    fun getAllPeople():LiveData<List<People>>{
//        val allpeople=PeopleListInfo.peopleList
//        return allpeople.reversed()
        return peopleDAO.getAll()
    }

    fun insertPeople(people: People){
//        PeopleListInfo.peopleList.add(people)
        peopleDAO.insert(people)

    }
    fun findPeople(id:Int):People?{
//        for (people in PeopleListInfo.peopleList){
//            if (people.id == id){
//                return people
//            }
//        }
//        return null
        return peopleDAO.find(id)
    }
}