package com.example.authapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.authapp.R
import com.example.authapp.data.Repository.UserRepositoryImpl
import com.example.authapp.data.remote.ApiClient
import com.example.authapp.data.remote.ApiService
import com.example.authapp.presentation.adapter.UserAdapter
import com.example.authapp.presentation.viewModel.UserViewModel
import com.example.authapp.presentation.viewModel.UserViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var userViewModel: UserViewModel

    private var currentPage = 1
    private val perPage = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(context)

        userAdapter = UserAdapter(mutableListOf())
        recyclerView.adapter = userAdapter

        // Mendapatkan instance ApiService melalui ApiClient
        val apiService: ApiService = ApiClient.getApiService()

        // Menginisialisasi UserRepository dengan ApiService
        val userRepository = UserRepositoryImpl(apiService)

        // Menginisialisasi UserViewModel dengan UserRepository
        userViewModel = ViewModelProvider(
            this,
            UserViewModelFactory(userRepository)
        ).get(UserViewModel::class.java)

        // Mengamati perubahan pada userList
        userViewModel.userList.observe(viewLifecycleOwner, Observer {
            userAdapter.updateList(it)
        })
        userViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })

        // Mengambil data pengguna dari API dengan menggunakan UserViewModel
        userViewModel.getUsers(currentPage, perPage)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val floatingButton: Button = view.findViewById(R.id.floatingButton)
        floatingButton.setOnClickListener {
            // Menambah halaman data atau dari page 1 ke page berikutnya
            currentPage++
            userViewModel.getUsers(currentPage, perPage)
            userAdapter.showLoading()
        }
    }
}