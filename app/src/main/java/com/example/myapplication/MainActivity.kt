package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var cont_1: TextView
    private lateinit var cont_2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cont_1 = findViewById(R.id.cont_1)
        cont_2 = findViewById(R.id.cont_2)
        val botonsito: Button = findViewById(R.id.accion)
        botonsito.setOnClickListener{
            contar()
        }
    }
    private fun contar() {
        val thread1 = Thread{
            for (i in 1..1000) {
                runOnUiThread {
                    cont_1.text = i.toString()
                }
                Thread.sleep(10)
            }
        }
        val thread2 = Thread{
            for (i in 1..1000){
                runOnUiThread {
                    cont_2.text = i.toString()
                }
                Thread.sleep(10)
            }
        }
        thread1.start()
        thread2.start()
    }
}