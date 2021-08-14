package com.rodrigo.nasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.rodrigo.nasaapi.databinding.ActivityMainBinding
import com.rodrigo.nasaapi.ui.NasaFactory
import com.rodrigo.nasaapi.ui.NasaViewModel

class MainActivity : AppCompatActivity() {


    private val nasaApp by lazy {
        application as NasaApplication
    }

    private val nasaFactory: NasaFactory by lazy {
        NasaFactory(nasaApp.repository)
    }

    private val nasaViewModel: NasaViewModel by viewModels {
        nasaFactory
    }


    private var _binding : ActivityMainBinding ?= null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel = nasaViewModel
            lifecycleOwner = this@MainActivity
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

    }
}