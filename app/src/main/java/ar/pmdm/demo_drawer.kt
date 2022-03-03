package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ar.pmdm.databinding.ActivityDemoDrawerBinding

class demo_drawer : AppCompatActivity() {

    private lateinit var binding:  ActivityDemoDrawerBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.contenido.barrita)
        supportActionBar!!.title = "Demo drawer"



        /*para añadir el boton de desplegar */
        val alternarDrawer = ActionBarDrawerToggle(this,binding.root,binding.contenido.barrita,R.string.abrir,R.string.cerrar)
        binding.root.addDrawerListener(alternarDrawer)
        alternarDrawer.syncState()
        /*fin para añadir el boton de desplegar */

        /* asingnar navegador a menu drawer*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.contenedorFragmentosView) as NavHostFragment
        navController = navHostFragment.navController
//        val navController = findNavController(R.id.contenedorFragmentosView)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.trozoFragment,R.id.pedazoFragment),binding.root)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.demoDrawerMenu.setupWithNavController(navController)

        binding.contenido.btDemoClick.setOnClickListener(){

//            showToast("Fragment actual: " + navController.currentDestination?.id.toString())
            showToast("Fragment actual: " + navController.currentDestination?.displayName.toString() + "(id: " + navController.currentDestination?.id.toString()+")")
        }


        binding.demoDrawerMenu.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.menu01_op03 -> {
                        showSnackBar(binding.demoDrawerMenu,"ya estas aquí")
                        showToast(getString(R.string.abrir))
                        binding.root.closeDrawer(GravityCompat.START) //cierra el drawer;
                    }
                R.id.menu01_op06 -> {
                        showSnackBar(binding.demoDrawerMenu,"vamos a liarla")
                        findNavController(R.id.contenedorFragmentosView).navigate(PedazoFragmentDirections.actionPedazoFragmentToTrozoFragment())

                }
                else -> {
                    showToast(it.title.toString())
                    binding.contenido.demo01TvCentral.text = it.title.toString();
                }
            }
            true
        }
    }

}