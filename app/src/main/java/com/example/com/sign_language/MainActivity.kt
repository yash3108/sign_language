package com.example.com.sign_language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.accuracy)
        textView.setText("Accuracy").toString()

        val tab1 = findViewById<TableLayout>(R.id.tableLayout)
        tab1.isVisible = false

        val algos = arrayOf("None","SVM","KNN","CNN","Random Forest","Compare All")
        val spin = findViewById<Spinner>(R.id.algo_options)
        if (spin != null)   {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, algos)
            spin.adapter = adapter

            spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    tab1.isVisible = false
                    val selected_string : String = parent?.getItemAtPosition(position).toString()
                    var acc = ""
                    Toast.makeText(this@MainActivity,
                        "Selected: "+algos[position], Toast.LENGTH_SHORT).show()
                    if(selected_string == "None"){
                        acc = ""
                    }
                    else if (selected_string == "SVM")   {
                        acc = "84.18% (84% - 85%)"
                    }
                    else if (selected_string == "KNN")  {
                        acc = "60%"
                    }
                    else if (selected_string == "CNN")  {
                        acc = "94.36% (93% - 96%)"
                    }
                    else if (selected_string == "Random Forest")   {
                        acc = "80% (Cumulative)"
                    }
                    else if (selected_string == "Compare All")  {
                        acc = ""
                        tab1.isVisible = true
                    }
                    textView.setText("Accuracy: " + acc)
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(this@MainActivity, "Select algorithm", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
