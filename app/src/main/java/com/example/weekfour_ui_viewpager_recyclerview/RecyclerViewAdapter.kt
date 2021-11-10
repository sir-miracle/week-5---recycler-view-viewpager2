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

//    private val images = listOf(
//        R.drawable.profile_1,
//        R.drawable.profile_2,
//        R.drawable.profile_4,
//        R.drawable.profile_3png
//    )
//    private val names = listOf(
//        "Seun",
//        "Tombari",
//        "Ayodele",
//        "Festus"
//    )

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//           var images = itemView.findViewById<ImageView>(R.id.profile_pix)
//            var profileName= itemView.findViewById<TextView>(R.id.profile_name)
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
       holder.bindItems(arrayList[position])
        //holder.profileName.text = names[position]
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }
}