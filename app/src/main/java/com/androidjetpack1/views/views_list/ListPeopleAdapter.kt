package com.androidjetpack1.views.views_list

import android.content.Intent
import android.net.Uri
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.androidjetpack1.R
import com.androidjetpack1.data.data_model.People
import kotlinx.android.synthetic.main.layout_list_item.view.*

class ListPeopleAdapter(
    private val items:List<People>,
    private val clickListener: OnItemClickListener
    ):RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    interface OnItemClickListener{
        fun onItemClick(people: People,ItemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position],clickListener)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(people: People,listener: OnItemClickListener)= with(itemView){
            textViewName.text=people.name
            textViewMet.text=people.metAt
            buttonContact.text=people.contact
            buttonContact.setOnClickListener {
                val dialIntent=Intent(Intent.ACTION_DIAL)
                dialIntent.data= Uri.parse("tel:${people.contact}")
                itemView.context.startActivity(dialIntent)
            }
            setOnClickListener{
                listener.onItemClick(people,it)
            }

        }
    }
}