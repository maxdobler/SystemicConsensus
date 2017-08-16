package de.maxdobler.systemicconsensus.team

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import de.maxdobler.systemicconsensus.R
import de.maxdobler.systemicconsensus.support.AppCompatLifecycleActivity
import kotlinx.android.synthetic.main.new_team_activity.*
import kotlinx.android.synthetic.main.toolbar.*

class NewTeamActivity : AppCompatLifecycleActivity() {
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_team_activity)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        setupToolbar()
        setupCreateTeamButton()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupCreateTeamButton() {
        createButton.setOnClickListener {
            val name = nameEditText.text.toString()
            viewModel.createNewGroup(name)
        }
    }
}
