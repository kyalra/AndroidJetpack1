package com.androidjetpack1.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.androidjetpack1.R

class MainClass:AppCompatActivity() {
    //1

   private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout)

        //2
        navigationController=findNavController(R.id.navigationHost)
        NavigationUI.setupActionBarWithNavController(this,navigationController)
    }
    //3
    override fun onSupportNavigateUp()=navigationController.navigateUp()
}