package com.example.accesoarecursos

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import com.example.accesoarecursos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var imagen: ImageButton
    lateinit var binding: ActivityMainBinding
    val pickFoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val image = it.data?.extras?.get("data") as Bitmap
        binding.botonImagen.setImageBitmap(image)

    }

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
        uri ->
        if (uri!=null){
            imagen.setImageURI(uri)
        }
        else{

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}