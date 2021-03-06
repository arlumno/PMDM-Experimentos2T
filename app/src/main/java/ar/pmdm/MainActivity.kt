package ar.pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import ar.pmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
            when(navController.currentDestination?.id) {
                R.id.trozoFragment -> navController.navigate(R.id.action_trozoFragment_to_pedazoFragment)
                R.id.pedazoFragment -> navController.navigate(R.id.action_pedazoFragment_to_trozoFragment)
                else -> showSnackBar(it);
            }
        }


        registerForContextMenu(binding.tvMenuC1)
        registerForContextMenu(binding.tvMenuC2)
//        binding.textView.setOnLongClickListener {
//            true
//        }

    }

/*menu normal*/
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
                startActivity(Intent(this, Demo01::class.java))
            }
            R.id.menu01_op02 -> {
                Toast.makeText(this, "Pulsado op2", Toast.LENGTH_SHORT).show()
            }
            R.id.menu01_op03 -> {
                startActivity(Intent(this, demo_drawer::class.java))
            }
            R.id.menu01_op04 -> {
                startActivity(Intent(this, bottom_navegador::class.java))
            }
            R.id.menu01_f1 -> {
                navController.navigate(R.id.action_pedazoFragment_to_trozoFragment)
            }
            else -> Toast.makeText(this, "Opci??n: " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

/* menu contextual*/
    lateinit var menuContextual: ContextMenu;

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuContextual = menu
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v.id){
            R.id.tvMenuC1 -> menuInflater.inflate(R.menu.menu01, menu)
            R.id.tvMenuC2 -> menuInflater.inflate(R.menu.menu02, menu)
        }

        menu.setHeaderTitle("Con-Textual")
}

    override fun onContextItemSelected(item: MenuItem): Boolean {
        showToast(
                 item.title.toString()
        )
       // menuContextual.removeItem(item.itemId)
        return super.onContextItemSelected(item)
    }


}