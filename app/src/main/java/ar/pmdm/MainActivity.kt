package ar.pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import ar.pmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "ElExperimento"
        supportActionBar!!.subtitle = "cosas"
        //setSupportActionBar(binding.barraHerramientas)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.elFrame) as NavHostFragment
        val navController = navHostFragment.navController

        binding.btTest.setOnClickListener{
            navController.navigate(R.id.action_pedazoFragment_to_trozoFragment)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu01, menu)
        // Se define el fichero de recursos res/menu/menu1.xml
        //menuInflater.inflate(R.menu.menu1clase, menu) // se pueden cargar dos menus
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.elFrame) as NavHostFragment
        val navController = navHostFragment.navController

        when (item.itemId) {
            R.id.menu01_op01 -> {
                Toast.makeText(this, "Pulsado op1", Toast.LENGTH_SHORT).show()
            }
            R.id.menu01_op02 -> {
                startActivity(Intent(this, Demo01::class.java))
            }
            R.id.menu01_f1 -> {
                navController.navigate(R.id.action_pedazoFragment_to_trozoFragment)
            }
            else -> Toast.makeText(this, "Opción: " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}