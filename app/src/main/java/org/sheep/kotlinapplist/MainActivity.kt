package org.sheep.kotlinapplist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        packageManager.getInstalledApplications(0).map { it.loadLabel(packageManager).toString() })
        listView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, pos, id ->
                    Toast.makeText(this, parent.getItemAtPosition(pos) as String, Toast.LENGTH_SHORT).show()
                }
    }
}
