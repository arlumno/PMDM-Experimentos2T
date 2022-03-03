package ar.pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
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

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.elFrame) as NavHostFragment
//        val navController = navHostFragment.navController

        binding.btDemoClick.setOnClickListener(){
            Toast.makeText(this,"Holita",Toast.LENGTH_SHORT).show();
            title = "cambiado el titulo"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        showToast(item.title.toString())
        return super.onOptionsItemSelected(item)
    }
}