package com.example.helloformxml

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var btnSaludar: Button
    private lateinit var tvMensaje: TextView
    private lateinit var tvContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asociar elementos
        etNombre = findViewById(R.id.etNombre)
        btnSaludar = findViewById(R.id.btnSaludar)
        tvMensaje = findViewById(R.id.tvMensaje)
        tvContador = findViewById(R.id.tvContador)

        // Botón deshabilitado al inicio
        btnSaludar.isEnabled = false

        // Listener del botón
        btnSaludar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()

            if (nombre.isEmpty()) {
                tvMensaje.text = "Introduce tu nombre"
            } else {
                tvMensaje.text = " Hola, $nombre"
                ocultarTeclado()
            }
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(etNombre.windowToken, 0)

            // Quitar el foco del EditText
            etNombre.clearFocus()
        }

        // TextWatcher para detectar cambios y actualizar contador
        etNombre.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val length = s?.length ?: 0
                tvContador.text = "$length / 20"
                btnSaludar.isEnabled = length > 0 // habilita/deshabilita botón
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    // Oculta el teclado
    private fun ocultarTeclado() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // resetear interfaz al salir
    override fun onStop() {
        super.onStop()
        resetUi()
    }

    private fun resetUi() {
        etNombre.setText("")
        tvMensaje.text = ""
        tvContador.text = "0 / 20"
        btnSaludar.isEnabled = false
    }
}