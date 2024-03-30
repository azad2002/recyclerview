package com.example.recyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class  MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity):
RecyclerView.Adapter<MyAdapter.MyViewholder>(){
    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)

    }
        fun setOnItemClickListener(listener : onItemClickListener){
             myListener = listener
        }


    //to create new view instance
    //when layout manager fails to find a suitable view for each items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_list,parent,false)
        return MyViewholder(itemView,myListener)

    }
// populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewholder, position: Int) {
        val currentItems = newsArrayList[position]
        holder.hTitle.text= currentItems.newsHeading
        holder.hImage.setImageResource(currentItems.newsImage)

    }
//how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size

    }
    // it hold  the view so views are not created everytime,so memory can be saved
    class MyViewholder(itemView: View,listener : onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


        }

    }

