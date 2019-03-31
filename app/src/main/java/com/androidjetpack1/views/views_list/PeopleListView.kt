package com.androidjetpack1.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People

class PeopleListView(application: Application):AndroidViewModel(application) {
    private val peopleRepo=getApplication<StartApp>().getPeopleRepo()
    private val peopleList=MediatorLiveData<List<People>>()

    init {
        getAllpeople()
    }

    fun getPeopleList():LiveData<List<People>>{
        return peopleList
    }
    fun getAllpeople(){
        peopleList.addSource(peopleRepo.getAllPeople()){
            peoples->peopleList.postValue(peoples)
        }
    }
}