package com.rodrigo.nasaapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigo.nasaapi.NasaApplication
import com.rodrigo.nasaapi.databinding.FragmentApiBinding
import com.rodrigo.nasaapi.ui.NasaFactory
import com.rodrigo.nasaapi.ui.NasaRv
import com.rodrigo.nasaapi.ui.NasaViewModel

class FragmentApi: Fragment() {

    private val nasaFactory by lazy {
        val app = requireActivity().application as NasaApplication
        NasaFactory(app.repository)
    }

    private val nasaViewModel: NasaViewModel by viewModels{
        nasaFactory
    }

    private var _binding: FragmentApiBinding ?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = nasaViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = NasaRv()

        val rv = binding.rvApod.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        nasaViewModel.getApod()

        nasaViewModel.apod.observe(viewLifecycleOwner){ response ->
            if (response.isSuccessful){
                response.body()?.let {
                    rvAdapter.setData(listOf(it))
                }
            }
        }
    }
}