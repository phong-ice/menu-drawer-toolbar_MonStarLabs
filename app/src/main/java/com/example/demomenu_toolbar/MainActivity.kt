package com.example.demomenu_toolbar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        val buttonNext: Button = findViewById(R.id.btn_next)
        buttonNext.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
        val buttonContextMenu: Button = findViewById(R.id.btn_contextMenu)
        registerForContextMenu(buttonContextMenu)

        val buttonPopupMenu: Button = findViewById(R.id.btn_popupMenu)
        buttonPopupMenu.setOnClickListener {
            var popup = PopupMenu(this, it)
            popup.setOnMenuItemClickListener(this)
            popup.inflate(R.menu.menu_test)
            popup.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_test, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_item_1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
            R.id.menu_item_3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
        }
        return false
    }

}