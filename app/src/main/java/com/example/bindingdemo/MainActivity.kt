package com.example.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //create the binding object
    //ActivityMainBinding class is created automatically after adding <layout></layout>
    //lateinit = assign data later because the view is not reading yet
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("W123", "Ali")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //throw student object to myData
        binding.myData = student

        //if working with others, one team handle UI, one team handle backend
        //backend team dk where to display the thing, so why not backend team pass the whole object to UI team
        //binding.tvStudentID.text = student.id
        //binding.tvStudentName.text = student.name

        binding.btnUpdate.setOnClickListener() {
            student.name = "Alex"

            //update the value/data, by notifying the view
            binding.apply {
                invalidateAll()
            }
        }

        //before using data binding
        //val tv: TextView = findViewById(R.id.tvStudentID)
        //tv.text = student.id

    }
}















