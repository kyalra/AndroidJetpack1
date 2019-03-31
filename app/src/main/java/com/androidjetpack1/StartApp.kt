package com.androidjetpack1

import android.app.Application
import com.androidjetpack1.data.ContactRepo

class StartApp:Application() {
    fun getPeopleRepo()=ContactRepo(this)
}