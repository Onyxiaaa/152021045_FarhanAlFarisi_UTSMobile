package com.example.uts.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.uts.R
import com.example.uts.databinding.FragmentFConversionBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FConversion.newInstance] factory method to
 * create an instance of this fragment.
 */
class FConversion : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view = inflater.inflate(R.layout.fragment_f_conversion, container, false)

        //region Inisialisasi button
        var pilihan1 = 0
        var pilihan2 = 0

        var gEdt_bil1 = view.findViewById<EditText>(R.id.edt_bil1)
        var gSpn1 = view.findViewById<Spinner>(R.id.spn1)
        var gSpn2 = view.findViewById<Spinner>(R.id.spn2)
        var gBtn_convertion = view.findViewById<Button>(R.id.btn_convertion)
        var gTxt_hasil = view.findViewById<TextView>(R.id.txt_hasil)
        var clearButton = view.findViewById<Button>(R.id.btn_clrconvert)
        //endregion

        //region tombol hitung
        gBtn_convertion.setOnClickListener {
            var bilangan = gEdt_bil1.text.toString().toDouble()
            var hasil = 0.0

            if(pilihan1.equals(0)){
                if(pilihan2.equals(0)){
                    hasil = bilangan
                } else if (pilihan2.equals(1)) {
                    hasil = bilangan * 0.00024
                } else if (pilihan2.equals(2)) {
                    hasil = bilangan * 0.00030
                } else if (pilihan2.equals(3)) {
                    hasil = bilangan * 0.0023
                }
            } else if (pilihan1.equals(1)){
                if(pilihan2.equals(0)){
                    hasil = bilangan * 4170.75
                } else if (pilihan2.equals(1)) {
                    hasil = bilangan
                } else if (pilihan2.equals(2)) {
                    hasil = bilangan * 1.25
                } else if (pilihan2.equals(3)) {
                    hasil = bilangan * 9.45
                }
            } else if (pilihan1.equals(2)){
                if(pilihan2.equals(0)){
                    hasil = bilangan * 3339.52
                } else if (pilihan2.equals(1)) {
                    hasil = bilangan * 0.80
                } else if (pilihan2.equals(2)) {
                    hasil = bilangan
                } else if (pilihan2.equals(3)) {
                    hasil = bilangan * 7.57
                }
            } else if (pilihan1.equals(3)){
                if(pilihan2.equals(0)){
                    hasil = bilangan * 441.35
                } else if (pilihan2.equals(1)) {
                    hasil = bilangan * 0.11
                } else if (pilihan2.equals(2)) {
                    hasil = bilangan * 0.13
                } else if (pilihan2.equals(3)) {
                    hasil = bilangan
                }
            }

            gTxt_hasil.text = hasil.toString()
        }
        //endregion

        //region spinner 1
        gSpn1.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Log.d("ahan", "item terpilih: " + position)
                    pilihan1 = position
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            })
        //endregion

        //region spinner 2
        gSpn2.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Log.d("ahan", "item terpilih: " + position)
                    pilihan2 = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            })
        //endregion

        clearButton.setOnClickListener {
            gEdt_bil1.text.clear()
            gTxt_hasil.text = ("")
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fMoney.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FConversion().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}