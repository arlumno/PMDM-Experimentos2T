package ar.pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import ar.pmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "ElExperimento"
        supportActionBar!!.subtitle = "cosas"


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu01, menu)
        // Se define el fichero de recursos res/menu/menu1.xml
        //menuInflater.inflate(R.menu.menu1clase, menu) // se pueden cargar dos menus
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu01_op01 -> {
                startActivity(Intent(this, demo01::class.java))
            }
            R.id.menu01_op02 -> {
                Toast.makeText(this, "Pulsado op2", Toast.LENGTH_SHORT).show()
            }
            else -> Toast.makeText(this, "Opción: " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}