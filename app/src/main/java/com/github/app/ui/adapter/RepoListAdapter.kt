package com.github.app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.app.R
import com.github.app.data.Github

class RepoListAdapter(
    var context: Context,
    var repolist: List<Github>,
    val adapterOnClick: (Any) -> Unit
) : RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repo_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = repolist.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.repoName.text = repolist[position].name
    }

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var repoName: TextView
        var parentLayout: LinearLayout

        init {
            repoName = itemView.findViewById(R.id.repoName)
            parentLayout = itemView.findViewById(R.id.parentRepo)
            parentLayout.setOnClickListener { adapterOnClick(repolist[adapterPosition]) }
        }
    }

}