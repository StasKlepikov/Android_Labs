package com.example.lab2fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lab2fragment.databinding.FragmentCalcBinding
import com.example.lab2fragment.databinding.FragmentResBinding


class FragmentRes : Fragment() {

    lateinit var binding: FragmentResBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.result.observe(this, {
            binding.tVRes.text = "Your result is $it"
        })
    }

    companion object {
               @JvmStatic
        fun newInstance() = FragmentRes()
    }
}