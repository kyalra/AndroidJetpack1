package com.androidjetpack1.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People

class AddPeopleViewModel(application: Application):AndroidViewModel(application) {
    private val peopleRepository=getApplication<StartApp>().getPeopleRepo()

    fun addPeople(people: People){
        peopleRepository.insertPeople(people)
    }
}