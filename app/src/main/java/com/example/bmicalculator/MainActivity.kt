package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calbtn.setOnClickListener(){
            val weight = insWeight.text.toString()
            val height = insHeight.text.toString()

            val total:Double = weight.toDouble() / Math.pow(height.toDouble(),2.00)
            try {
                if(total < 18.5){
                    totBmi.text = "%.2f (Underweight)".format(total)
                    imgResult.setImageResource(R.drawable.under)
                }
                else if(total > 25){
                    totBmi.text = "%.2f (Overweight)".format(total)
                    imgResult.setImageResource(R.drawable.over)
                }
                else{
                    totBmi.text = "%.2f (Normal)".format(total)
                    imgResult.setImageResource(R.drawable.normal)
                }
            }catch (ex:Exception){
                val toast:Toast = Toast.makeText(applicationContext, "Weight and Height cannot leave Blank!!",Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }

        }

        resbtn.setOnClickListener(){
            insHeight.text.clear()
            insWeight.text.clear()
            imgResult.setImageResource(R.drawable.empty)
        }


    }
}
