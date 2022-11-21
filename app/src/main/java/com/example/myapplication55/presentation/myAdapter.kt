package com.example.myapplication55.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication55.data.DataItem
import com.example.myapplication55.databinding.ItemUserBinding

class myAdapter(val context: Context,val userList:List<DataItem>): RecyclerView.Adapter<myAdapter.userHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
       val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return userHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
       holder.userId.text = userList[position].userId.toString()
        holder.title.text = userList[position].title
    }

    override fun getItemCount(): Int {
        return userList.size
    }
class userHolder(private val itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root){
    var userId: TextView
    var title: TextView
    init {
        userId = itemBinding.userID
        title = itemBinding.title
    }

   // fun bind(userId: String, title: String){
   //     itemBinding.userID.text = userId
   // }
}
    interface Listener{
        fun onClick(title: DataItem){

        }
    }
}