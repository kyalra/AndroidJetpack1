package com.androidjetpack1.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidjetpack1.R
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People
import com.androidjetpack1.views.views_list.PeopleListView
import kotlinx.android.synthetic.main.fragment_add_people.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailFragment : Fragment () {
    private lateinit var viewmodel:DetailsPeopleModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel=ViewModelProviders.of(this).get(DetailsPeopleModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val peopeId = activity?.intent?.getIntExtra(getString(R.string.people_id), 0)
        val peopleId= arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewmodel.getPeopleDetails(peopleId).observe(this, Observer { peopledDetails ->
                populatePeopleDetails(peopledDetails)
            })
        }
    }
private fun populatePeopleDetails(people: People?){
    textViewName.text=people?.name
    textViewMet.text=people?.metAt
    buttonContact.text=people?.contact
    textViewEmail.text=people?.email
    textViewFacebook.text=people?.facebook
    textViewTwiter.text=people?.twitter
}
}