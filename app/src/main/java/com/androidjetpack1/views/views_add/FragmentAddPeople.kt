package com.androidjetpack1.views.views_add

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.androidjetpack1.R
import com.androidjetpack1.StartApp
import com.androidjetpack1.data.data_model.People
import kotlinx.android.synthetic.main.fragment_add_people.*

class FragmentAddPeople:Fragment() {
    lateinit var btn_:Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater.inflate(
            R.layout.fragment_add_people,
            container, false)
        btn_=view.findViewById(R.id.btn_)

        return view
    }

    private fun savePeopleInfo() {
        val people = People(
            textInputName.editText?.text.toString(),
            textInputMetAt.editText?.text.toString(),
            textInputContact.editText?.text.toString(),
            textInputEmail.editText?.text.toString(),
            textInputFacebook.editText?.text.toString(),
            textInputTwitter.editText?.text.toString()
        )
        (activity?.application as StartApp).getPeopleRepo().insertPeople(people)
        activity?.finish()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleInfo()
        }
    }
}