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

class MainActivity : AppCompatLifecycleActivity() {
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        setSupportActionBar(toolbar)
        setupNewTeamButton()
        setupTeamList()
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
