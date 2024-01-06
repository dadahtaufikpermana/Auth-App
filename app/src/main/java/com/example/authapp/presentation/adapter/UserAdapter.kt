package com.example.authapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.authapp.R
import com.example.authapp.data.model.User

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)

        fun bind(user: User) {
            textViewName.text = "${user.first_name} ${user.last_name}"
            textViewEmail.text = user.email
            textViewId.text = user.id.toString()

            Glide.with(itemView.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}