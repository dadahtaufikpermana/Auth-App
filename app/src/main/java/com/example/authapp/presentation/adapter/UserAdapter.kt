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

class UserAdapter(private var userList: MutableList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

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

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
            ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.loading_item, parent, false)
            LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(userList[position])
        } else if (holder is LoadingViewHolder) {
            // Tampilkan loading indicator jika diperlukan
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (userList[position].id != -1) VIEW_TYPE_ITEM else VIEW_TYPE_LOADING
    }

    fun updateList(newList: List<User>) {
        hideLoading()
        userList.addAll(newList)
        notifyDataSetChanged()
    }

    fun showLoading() {
        userList.add(User(-1, "", "", "", ""))
        notifyItemInserted(userList.size - 1)
    }

    fun hideLoading() {
        val lastPosition = userList.size - 1
        if (lastPosition >= 0 && userList[lastPosition].id == -1) {
            userList.removeAt(lastPosition)
            notifyItemRemoved(lastPosition)
        }
    }
}