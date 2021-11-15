package com.example.weekfour_ui_viewpager_recyclerview

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val arrayList:ArrayList<Model>, val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> () {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(model: Model){
            itemView.findViewById<TextView>(R.id.profile_name).text = model.name
            itemView.findViewById<ImageView>(R.id.profile_pix).setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItems(arrayList[position]) //this makes the adapter away of which position it is at in the list of items it is recycling
    }

    override fun getItemCount(): Int {
       return arrayList.size  // Get the size of the list that holds the items to recycle
    }
}