package com.androidjetpack1.views.views_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People

class DetailsPeopleModel(application: Application):AndroidViewModel(application) {
    private val peopleRepository= getApplication<StartApp>().getPeopleRepo()
    private val peopleId=MutableLiveData<Int>()

    //maps people id to people details
    fun getPeopleDetails(id:Int):LiveData<People>{
        peopleId.value=id
        val poepleDetails=Transformations.switchMap<Int,People>(peopleId){id->
            peopleRepository.findPeople(id)
        }
        return poepleDetails
    }
}