package de.maxdobler.systemicconsensus

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.maxdobler.systemicconsensus.group.NewGroupActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newGroupButton.setOnClickListener {
            val intent = Intent(this, NewGroupActivity::class.java)
            startActivity(intent)
        }
    }
}
