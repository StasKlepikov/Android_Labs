package com.example.lab2fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.lab2fragment.databinding.FragmentCalcBinding

class FragmentCalc : Fragment() {

    lateinit var binding: FragmentCalcBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcBinding.inflate(inflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnOk.setOnClickListener {
            if (binding.enterA.text.isNullOrEmpty() || binding.enterB.text.isNullOrEmpty()) {
                Toast.makeText(activity, "Make your choice firstly", Toast.LENGTH_SHORT).show()
            }
            else {

                when {
                    binding.rbtnPlus.isChecked -> {

                        dataModel.result.value = binding.enterA.text.toString().toDouble() + binding.enterB.text.toString().toDouble()
                    }
                    binding.rbtnMinus.isChecked -> {

                        dataModel.result.value = binding.enterA.text.toString().toDouble() - binding.enterB.text.toString().toDouble()
                    }
                    binding.rbtnMultiply.isChecked -> {

                        dataModel.result.value = binding.enterA.text.toString().toDouble() * binding.enterB.text.toString().toDouble()
                    }
                    binding.rbtnDivide.isChecked -> {

                        dataModel.result.value = binding.enterA.text.toString().toDouble() / binding.enterB.text.toString().toDouble()
                    }
                }
            }
        }
        binding.btnClear.setOnClickListener {
            binding.rbGroup.clearCheck()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentCalc()
    }
}