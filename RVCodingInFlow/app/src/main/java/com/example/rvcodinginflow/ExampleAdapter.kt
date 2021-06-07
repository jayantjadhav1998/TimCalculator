package com.example.rvcodinginflow

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


    class ExampleAdapter:RecyclerView.Adapter(){
        class ExampleViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
            val imageView:ImageView=itemView.findViewById(R.id.image_view)
        }
    }
