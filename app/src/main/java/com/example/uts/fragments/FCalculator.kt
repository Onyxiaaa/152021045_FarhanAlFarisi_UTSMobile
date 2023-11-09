package com.example.uts.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.uts.databinding.FragmentFCalculatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FCalculator.newInstance] factory method to
 * create an instance of this fragment.
 */
class FCalculator : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentFCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pilihan = 0

        var gEdt1 = binding.edtBil1
        var gEdt2 = binding.edtBil2
        var gSpin = binding.myspinner
        var GbtnCal = binding.btnCalculate
        var gTvHasil = binding.tvHasil

        binding.btnCalculate.setOnClickListener {
            var nilai1 = gEdt1.text.toString().toDouble()
            var nilai2 = gEdt2.text.toString().toDouble()
            var hasil = 0.0

            Log.d("ahan", "nilai1" + nilai1 +
                    ", nilai 2:" + nilai2)

            if (pilihan.equals(0)){
                hasil = nilai1 + nilai2
            }
            else if (pilihan.equals(1)){
                hasil = nilai1 - nilai2
            }
            else if (pilihan.equals(2)){
                hasil = nilai1 * nilai2
            }
            else if (pilihan.equals(3)){
                hasil = nilai1 / nilai2
            }

            gTvHasil.text = hasil.toString()
        }
        gSpin.setOnItemSelectedListener(

            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Log.d("ahan","pilih item:" + p2)
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            })
    }

}