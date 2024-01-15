package com.example.accesoarecursos

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.accesoarecursos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var imagen: ImageButton
    lateinit var binding: ActivityMainBinding
    val pickFoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val image = it.data?.extras?.get("data") as Bitmap
        binding.botonImagen.setImageBitmap(image)

    }

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            imagen.setImageURI(uri)
        } else {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //se llama a un launcher que pide que se seleccione una imagen
        binding.botonImagen.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        //cuando se pulse el botón de acceder a la cámara, se llamará al launcher para lanzarlo
        binding.bAccesoCamara.setOnClickListener {
            pickFoto.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
}