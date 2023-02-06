package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.01f)
        tvResult.text = result.toString()

        var classificacao = if (result < 18.5f){
            "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f){
            "PESO NORMAL"
        }else if (result in 24.9f..29.9f){
            "SOBREPESO"
        }else if (result in 29.9f..39.9f) {
             "OBESIDADE 1"
        }else{

            "OBESIDADE GRAVE 2"
        }

        tvclassificacao.text = getString(R.string.message_classificação, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}