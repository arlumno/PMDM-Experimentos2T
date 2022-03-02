package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.pmdm.databinding.ActivityBottomNavegadorBinding
import ar.pmdm.databinding.ActivityDemo01Binding
import ar.pmdm.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class bottom_navegador : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavegadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavegadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}