package de.maxdobler.systemicconsensus.team

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import de.maxdobler.systemicconsensus.R
import kotlinx.android.synthetic.main.new_team_activity.*

class NewTeamActivity : LifecycleActivity() {
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_team_activity)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        createButton.setOnClickListener {
            val name = nameEditText.text.toString()
            viewModel.createNewGroup(name)
        }
    }
}
