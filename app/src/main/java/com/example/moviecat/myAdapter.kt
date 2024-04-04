package com.example.moviecat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecat.Data.DataClassItem
import com.example.moviecat.databinding.ItemsBinding

class myAdapter(var con : Context, val list: List<DataClassItem>?) :RecyclerView.Adapter<myAdapter.myViewHolder> () {

   inner class myViewHolder(val itemViewBinding : ItemsBinding ):RecyclerView.ViewHolder(itemViewBinding.root) {

       var textID = itemViewBinding.itemId
       var textTitle = itemViewBinding.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return  myViewHolder(ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list!!.count()
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.textID.text = list!![position]?.id.toString()
        holder.textTitle.text = list!![position]?.title
    }


}