package ar.pmdm

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Activity.showToast(mensaje: String = "showToast", contexto: Context = this,duracion: Int = Toast.LENGTH_SHORT){
    Toast.makeText(contexto,mensaje,duracion).show();
}
fun Activity.showSnackBar( vista: View, mensaje: String = "showSnackBar", duracion: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(vista,mensaje,duracion).show()
}

fun TextView.asingarTexto(texto: String?){
    texto?.let { setText(texto)  } ?: setText("")
}
fun TextView.asingarTexto(texto: Int?){
    texto?.let { setText(texto.toString())  } ?: setText("")
}