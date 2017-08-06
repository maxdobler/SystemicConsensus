package de.maxdobler.systemicconsensus.group

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import de.maxdobler.systemicconsensus.R
import kotlinx.android.synthetic.main.new_group_activity.*

class NewGroupActivity : LifecycleActivity() {
    private lateinit var viewModel: NewGroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_group_activity)
        viewModel = ViewModelProviders.of(this).get(NewGroupViewModel::class.java)

        createButton.setOnClickListener {
            val name = nameEditText.text.toString()
            viewModel.createNewGroup(name)
        }
    }
}
