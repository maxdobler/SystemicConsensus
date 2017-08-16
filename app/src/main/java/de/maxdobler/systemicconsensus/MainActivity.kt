package de.maxdobler.systemicconsensus

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import de.maxdobler.systemicconsensus.support.AppCompatLifecycleActivity
import de.maxdobler.systemicconsensus.team.NewTeamActivity
import de.maxdobler.systemicconsensus.team.TeamListRecyclerAdapter
import de.maxdobler.systemicconsensus.team.TeamViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatLifecycleActivity() {
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        setupToolbar()
        setupNewTeamButton()
        setupTeamList()
    }

    private fun setupToolbar() {
        toolbar.title = getString(R.string.main_activity_toolbar_title)
        setSupportActionBar(toolbar)
    }

    private fun setupNewTeamButton() {
        newTeamButton.setOnClickListener {
            val intent = Intent(this, NewTeamActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupTeamList() {
        val teamsListRecyclerAdapter = TeamListRecyclerAdapter()
        teamList.layoutManager = LinearLayoutManager(this)
        teamList.adapter = teamsListRecyclerAdapter
        viewModel.teams.observe(this, Observer {
            it?.let { teamsListRecyclerAdapter.replaceItems(it) }
        })
    }
}
