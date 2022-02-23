package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.pmdm.databinding.ActivityDemo01Binding

class Demo01 : AppCompatActivity() {
    private lateinit var binding: ActivityDemo01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.barrita)  /* Al utilizar toolbar tenemos que asignar
        qué toolbar se utiliza como ActionBar. */

        supportActionBar!!.title = "Demo 01"

    }
}