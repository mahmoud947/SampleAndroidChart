package com.example.sampleandroidchart

import android.graphics.Color
import android.graphics.Typeface
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sampleandroidchart.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class MainActivity : AppCompatActivity() {

    private lateinit var barList:MutableList<BarEntry>

    private val calendar: Calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)

    private val statValues: ArrayList<Float> = ArrayList()

    protected val statsTitles = arrayOf(
        "Orders", "Inventory"
    )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        barList = mutableListOf()

        getData()
        val barDataSet = BarDataSet(barList,"Test")
        val barData = BarData(barDataSet)

        binding.barChart.data = barData
        barDataSet.setColors(Color.BLACK)



    }

    fun getData(){
        barList.add(BarEntry(2f,10f))
        barList.add(BarEntry(3f,10f))
        barList.add(BarEntry(7f,120f))
        barList.add(BarEntry(6f,6f))
        barList.add(BarEntry(4f,20f))
    }



}