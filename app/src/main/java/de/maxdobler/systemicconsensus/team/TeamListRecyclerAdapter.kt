package de.maxdobler.systemicconsensus.team

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.maxdobler.systemicconsensus.R
import kotlinx.android.synthetic.main.team_item.view.*


class TeamListRecyclerAdapter(private var items: List<Team> = emptyList()) : RecyclerView.Adapter<TeamListRecyclerAdapter.GroupViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        return GroupViewHolder(view)
    }

    fun replaceItems(items: List<Team>) {
        this.items = items
        notifyDataSetChanged()
    }

    class GroupViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(team: Team) {
            itemView.teamName.setText(team.name)
        }

    }

}
