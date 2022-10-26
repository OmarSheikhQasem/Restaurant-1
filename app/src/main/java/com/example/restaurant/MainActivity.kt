package com.example.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btFees)
        val edtxt1: EditText = findViewById(R.id.edBurgers)
        val edtxt2: EditText = findViewById(R.id.edDrinks)
        val TotalTV: TextView = findViewById(R.id.Total)
        var flag: String = "Meat"
        val spinnerVal: Spinner = findViewById(R.id.spinnerBurgers)
        var options = arrayOf("Meat","Chicken")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        var flag1: String = "Cola"
        val spinnerVal1: Spinner = findViewById(R.id.spinnerDrinks)
        var options1 = arrayOf("Cola","Sprite")
        spinnerVal1.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options1)
        spinnerVal1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1 = options1.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        button.setOnClickListener{
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            if(flag=="Meat")
            {
                if(flag1=="Cola")
                    TotalTV.text = (""+Meat_Cola(x,y).toString()+"$")
                else
                    TotalTV.text = (""+Meat_Sprite(x,y).toString()+"$")
            }
            else
            {
                if(flag1=="Cola")
                    TotalTV.text = (""+Chicken_Cola(x,y).toString()+"$")
                else
                    TotalTV.text = (""+Chicken_Sprite(x,y).toString()+"$")
            }
        }
    }
}

public fun Meat_Cola(a: Int, b: Int): Int
{
    return a*2+b*1;
}

public fun Chicken_Cola(a: Int, b: Int): Int
{
    return a*3+b*1;
}

public fun Meat_Sprite(a: Int, b: Int): Int
{
    return a*2+b*2;
}

public fun Chicken_Sprite(a: Int, b: Int): Int
{
    return a*3+b*2;
}