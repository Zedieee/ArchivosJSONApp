package com.example.archivosjson

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DescMun : AppCompatActivity() {
    private lateinit var estadoSelected: TextView
    private lateinit var municipioSelected: TextView
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descmun)
        estadoSelected = findViewById(R.id.estadoTextView)
        municipioSelected = findViewById(R.id.municipioTextView)
        image = findViewById(R.id.imagenMunicipioImageView)

        val estado = intent.getStringExtra("nombre")
        val municipio = intent.getStringExtra("municipio")
        var nombreimg = estado?.lowercase()
        nombreimg = nombreimg?.replace(" ", "_")

        estadoSelected.text = estado
        municipioSelected.text = municipio
        image.setImageResource(resources.getIdentifier(nombreimg, "drawable", packageName))






    }


}