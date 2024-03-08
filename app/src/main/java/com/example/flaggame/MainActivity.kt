package com.example.flaggame

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.flaggame.R
import com.example.flaggame.databinding.ActivityMainBinding

import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el NavController
        val navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()

        // Configurar BottomNavigationView con NavController
        binding.bottomNavigationView.setupWithNavController(navController!!)
    }
}

