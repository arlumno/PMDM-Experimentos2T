package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ar.pmdm.databinding.ActivityDemo01Binding
import ar.pmdm.databinding.ActivityDemoDrawerBinding
import ar.pmdm.databinding.ActivityMainBinding

class demo_drawer : AppCompatActivity() {

    private lateinit var binding:  ActivityDemoDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.contenido.barrita)
        supportActionBar!!.title = "Demo drawer"
    }

}