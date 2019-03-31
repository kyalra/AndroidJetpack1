package com.androidjetpack1.views.views_list

import android.app.Fragment
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androidjetpack1.R
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People
import com.androidjetpack1.views.views_add.AddPeopleData
import com.androidjetpack1.views.views_details.DetailAct
import kotlinx.android.synthetic.main.fragment_for_list_people.*

class ListPeopleFragment:Fragment(),ListPeopleAdapter.OnItemClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_people, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
           val intent=Intent(activity.applicationContext,AddPeopleData::class.java)
            startActivity(intent)
        }
    }


    override fun onItemClick(people: People, ItemView: View) {
        Toast.makeText(
            activity.applicationContext, "Test Click Contact List",
            Toast.LENGTH_SHORT
        ).show()
        val detailIntent=Intent(activity.applicationContext,DetailAct::class.java)
        detailIntent.putExtra(getString(R.string.people_id),people.id)
        startActivity(detailIntent)

    }
    private fun populatePeopleList(peopleList:List<People>){
        peopleRecyclerView.adapter=ListPeopleAdapter(peopleList,this)
    }

    override fun onResume() {
        super.onResume()

//        val people=(activity?.application as StartApp).getPeopleRepo().getAllPeople()
//        populatePeopleList(people)
        val peopleRepo=(activity?.application as StartApp).getPeopleRepo()
        peopleRepo.getAllPeople().observe(this, Observer {
            peopleList->populatePeopleList(peopleList!!)
        })
    }
}