package com.example.recyclerviewbolgex

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbolgex.model.BlogPost

class BlogRecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items:List<BlogPost> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class BlogViewHolder constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView){
    val blog_image=itemView.blog_image
        val blogTitle=itemView.blog_title
        val blogAuthor=itemView.blog_Author 
    }
}