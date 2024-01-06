package com.example.authapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.authapp.R
import com.example.authapp.data.model.User
import com.example.authapp.presentation.adapter.UserAdapter

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Dummy data untuk testing
        val userList = listOf(
            User(1, "John", "Doe", "john@example.com", "https://example.com/john.jpg"),
            User(1, "John", "Doe", "john@example.com", "https://example.com/john.jpg"),
            User(1, "John", "Doe", "john@example.com", "https://example.com/john.jpg"),
            User(1, "John", "Doe", "john@example.com", "https://example.com/john.jpg"),
            // Add more users as needed
        )

        userAdapter = UserAdapter(userList)
        recyclerView.adapter = userAdapter

        return view
    }
}