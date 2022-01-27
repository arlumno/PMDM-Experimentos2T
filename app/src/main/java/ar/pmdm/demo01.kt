package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.pmdm.databinding.ActivityDemo01Binding

class demo01 : AppCompatActivity() {
    private lateinit var binding: ActivityDemo01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo01Binding.inflate(layoutInflater)

        setContentView(binding.root)

        setTitle("Demo 01")

    }
}