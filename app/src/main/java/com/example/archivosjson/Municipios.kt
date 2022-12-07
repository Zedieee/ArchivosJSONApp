package com.example.archivosjson

import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import android.os.Bundle as Bundle1

class Municipios: AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var lista: ArrayList<String>
    private lateinit var municipio: TextView
    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_municipios)
        listView = findViewById(R.id.listaMun)
        lista = ArrayList()
        municipio = findViewById(R.id.textView)


        val id = intent.getIntExtra("id", 1)
        val nombre = intent.getStringExtra("nombre")

        val jsonMunicipios = JSONArray(
            (JSONTokener(
                assets.open("municipios.json").bufferedReader().use { it.readText() }))
        )
        val jsonMun = jsonMunicipios.getJSONObject(id-1 )
val jsonMunArray = jsonMun.getJSONObject(nombre)
        for(i in 1..jsonMunArray.length() ){
            val municipio = jsonMunArray.getString(i.toString())
            lista.add(municipio)

        }
        ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DescMun::class.java)
            intent.putExtra("municipio", lista[position])
            intent.putExtra("nombre", nombre)
            startActivity(intent)
        }
    }

    }

