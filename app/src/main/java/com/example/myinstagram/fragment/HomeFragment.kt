package com.example.myinstagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstagram.R
import com.example.myinstagram.adapter.AdapterStatus
import com.example.myinstagram.adapter.tampilan
import com.example.myinstagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var status: RecyclerView
    private val list = ArrayList<tampilan>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        status = binding.recyclerStatus
        status.setHasFixedSize(true)

        list.addAll(tampilin())
        daftarnya()
    }
    private fun daftarnya(){
        status.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        status.adapter = AdapterStatus(list)
    }

    private fun tampilin(): ArrayList<tampilan> {
        val dataJudul = resources.getStringArray(R.array.data_user)
        val dataPhoto = resources.obtainTypedArray(R.array.data_status)
        val listTampil = ArrayList<tampilan>()
        for (i in dataJudul.indices) {
            val tampil = tampilan(dataJudul[i], dataPhoto.getResourceId(i, -1))
            listTampil.add(tampil)
        }
        return listTampil
    }
}