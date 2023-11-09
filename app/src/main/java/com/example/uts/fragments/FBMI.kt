package com.example.uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uts.R
import com.example.uts.databinding.FragmentFBMIBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FBMI.newInstance] factory method to
 * create an instance of this fragment.
 */
class FBMI : Fragment() {
    private lateinit var binding: FragmentFBMIBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFBMIBinding.inflate(inflater, container, false)

        binding.weightpicker.minValue = 30
        binding.weightpicker.maxValue = 150
        binding.heightpicker.minValue = 100
        binding.heightpicker.maxValue = 250

        binding.weightpicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }
        binding.heightpicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        // Restore state if available
        savedInstanceState?.let {
            binding.weightpicker.value = it.getInt("weight", 30)
            binding.heightpicker.value = it.getInt("height", 100)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("weight", binding.weightpicker.value)
        outState.putInt("height", binding.heightpicker.value)
    }

    private fun calculateBMI() {
        val height = binding.heightpicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightpicker.value
        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultTV.append("\nKeterangan: " + healthyMessage(bmi))
        binding.resultTV.text = String.format("BMI kamu adalah: %.2f", bmi)
    }

    private fun healthyMessage(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi < 24.9 -> "Sehat"
            bmi < 29.9 -> "Kegemukan"
            else -> "Obesitas"
        }
    }

}