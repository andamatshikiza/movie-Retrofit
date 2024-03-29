package com.example.moviecat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecat.Data.DataClassItem
import com.example.moviecat.databinding.ItemsBinding

class myAdapter(val list: ArrayList<DataClassItem>) :RecyclerView.Adapter<myAdapter.myViewHolder> () {

   inner class myViewHolder(val itemViewBinding : ItemsBinding ):RecyclerView.ViewHolder(itemViewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return  myViewHolder(ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.itemViewBinding.title.text = list[position].toString()
        holder.itemViewBinding.itemId.text = list[position].toString()
    }


}