package com.androidjetpack1.data.data_model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class People (
    var name:String="",
    var metAt:String="",
    var contact:String="",
    var email:String="",
    var facebook:String="",
    var twitter:String="",

    @PrimaryKey (autoGenerate=true)var id:Int=0
)
