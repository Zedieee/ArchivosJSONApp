package com.example.archivosjson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var lista:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        lista = ArrayList()
        val jsonEstados = JSONArray(JSONTokener(assets.open("estados.json").bufferedReader().use { it.readText() }) )

        for (i in 0 until jsonEstados.length()) {
            val estado = jsonEstados.getJSONObject(i)
            val id = estado.getInt("id")
            val nombre = estado.getString("nombre")

            val estadoString = "$id - $nombre "
            lista.add(nombre)


            ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        }


           listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, Municipios::class.java)
                intent.putExtra("id", position+1)
               intent.putExtra("nombre", lista[position])
                startActivity(intent)
            }



    }

}