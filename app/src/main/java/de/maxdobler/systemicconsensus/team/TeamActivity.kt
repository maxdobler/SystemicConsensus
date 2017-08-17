package de.maxdobler.systemicconsensus.team

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import de.maxdobler.systemicconsensus.R
import de.maxdobler.systemicconsensus.support.AppCompatLifecycleActivity
import kotlinx.android.synthetic.main.team_activity.*
import kotlinx.android.synthetic.main.toolbar.*


class TeamActivity : AppCompatLifecycleActivity() {
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_activity)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        setupToolbar()
        setupNewTeamButton()
        setupTeamList()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setupNewTeamButton() {
        newTeamButton.setOnClickListener {
            val intent = Intent(this, NewTeamActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupTeamList() {
        val layoutManager = LinearLayoutManager(this)
        teamList.addItemDecoration(DividerItemDecoration(teamList.getContext(), layoutManager.getOrientation()))
        teamList.layoutManager = layoutManager

        val teamsListRecyclerAdapter = TeamListRecyclerAdapter()
        teamList.adapter = teamsListRecyclerAdapter

        viewModel.teams.observe(this, Observer {
            it?.let { teamsListRecyclerAdapter.replaceItems(it) }
        })
    }
}
