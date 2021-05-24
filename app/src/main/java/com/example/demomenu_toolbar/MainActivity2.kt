package com.example.demomenu_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerToggle:ActionBarDrawerToggle
    private lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar:Toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        val drawerLayout:DrawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        drawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener(this)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test2, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        when (item.itemId) {
            R.id.menu_item2_1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item2_2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item2_3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}