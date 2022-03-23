package com.example.switchicon

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var click: TextView? = null
    var newicon: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click = findViewById(R.id.oldicon)
        newicon = findViewById(R.id.newicon)
        click?.setOnClickListener { changeicon() }
        newicon?.setOnClickListener { newicon() }
    }

    private fun changeicon() {
        val manager = packageManager
        // enable old icon
        manager.setComponentEnabledSetting(
            ComponentName(this@MainActivity, "com.example.switchicon.MainActivity"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )

        // disable new icon
        manager.setComponentEnabledSetting(
            ComponentName(this@MainActivity, "com.example.switchicon.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        Toast.makeText(this@MainActivity, "Enable Old Icon", Toast.LENGTH_LONG).show()
    }

    private fun newicon() {
        val manager = packageManager
        // disable old icon
        manager.setComponentEnabledSetting(
            ComponentName(this@MainActivity, "com.example.switchicon.MainActivity"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )

        // enable new icon
        manager.setComponentEnabledSetting(
            ComponentName(this@MainActivity, "com.example.switchicon.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        Toast.makeText(this@MainActivity, "Enable New Icon", Toast.LENGTH_LONG).show()
    }
}
