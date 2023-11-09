package com.example.uts.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.uts.R
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FGraph.newInstance] factory method to
 * create an instance of this fragment.
 */

var nilai_rata2 = ArrayList<Int>()
var nilai  = ArrayList<Int>()
var nama = ArrayList<String>()
var j = 0
var a =1 ;

class FGraph : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_f_graph, container, false)
        val aaChartView = rootView.findViewById<AAChartView>(R.id.aa_chart_view)
        val button = rootView.findViewById<Button>(R.id.masukan)
        val input = rootView.findViewById<EditText>(R.id.inputnilai)
        var text = rootView.findViewById<TextView>(R.id.matpel)
        button.setOnClickListener {
            if (j == 0) {
                var value = input.text.toString()
                nama.add(value)
                Log.i("Value", nama.toString())
                j++
            } else {
                var value = input.text.toString().toInt()

                nilai.add(value)
                Log.i("Nilai", nilai.toString())
            }
            if (nilai.size == 0) {
                text.setText("Masukan Matakuliah Indonesia")
            } else if (nilai.size == 1) {
                text.setText("Masukan Matakuliah Agama")
            } else if (nilai.size == 2) {
                text.setText("Masukan Matakuliah Matematika")
            } else if (nilai.size == 3) {
                text.setText("Masukan Matakuliah Fisika")
            } else if (nilai.size == 4) {
                text.setText("Masukan Matakuliah Kimia")
            } else if (nilai.size == 5) {
                text.setText("Masukan Matakuliah Ekonomi")
                var nil = 0
                for (i in nilai){
                    nil += i
                }
                nil /= nilai.size
                nilai_rata2.add(nil)
                nilai.clear()
                if (nilai.isEmpty()){
                    a++
                    text.setText("Masukan Nama Siswa ke -  " + a+" = ")
                    j=0
                }
            }



            var myList = listOf(70, 80)
            var myArray = nilai_rata2.toTypedArray()
            var nmearray = nama.toTypedArray()
            val aaChartModel: AAChartModel = AAChartModel()
                .chartType(AAChartType.Bar)
                .title("Rata rata nilai")
                .categories(arrayOf(*nmearray))
                .subtitle("subtitle")
                .backgroundColor("#4b2b7f")
                .dataLabelsEnabled(true)
                .series(
                    arrayOf(
                        AASeriesElement()
                            .name("Nilai Rata Rata")
                            .data(arrayOf(*myArray))
                    )
                )
            aaChartView.aa_drawChartWithChartModel(aaChartModel)
        }
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FGraph.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FGraph().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}