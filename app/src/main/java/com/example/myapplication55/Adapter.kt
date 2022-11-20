package com.example.myapplication55

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication55.databinding.ItemUserBinding

class Adapter(val userList:List<String>): RecyclerView.Adapter<Adapter.userHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
       val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return userHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
        val name = userList[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
class userHolder(private val itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root){
    fun bind(name: String){
        itemBinding.userName.text= name
    }
}
}