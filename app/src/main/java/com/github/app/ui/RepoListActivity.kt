package com.github.app.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.app.R
import com.github.app.data.Github
import com.github.app.ui.RepoDetailActivity.Companion.IMAGE
import com.github.app.ui.RepoDetailActivity.Companion.OPEN_ISSUE
import com.github.app.ui.RepoDetailActivity.Companion.OWNER
import com.github.app.ui.RepoDetailActivity.Companion.STAR_COUNT
import com.github.app.ui.adapter.RepoListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject

class RepoListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: RepoViewModel
    lateinit var adapter: RepoListAdapter
    lateinit var pDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.repos.observe(this, Observer {
            pDialog.hide()
            if (!it.isNullOrEmpty()) {
                initAdapter(it)
            }
        })

        btnSubmit.setOnClickListener {
            if (!repoKeyword.text.toString().isNullOrEmpty()) {
                initProgressDialog()
                viewModel.getRepos(repoKeyword.text.toString().trim())
            }
        }
    }

    private fun initProgressDialog() {
        pDialog = indeterminateProgressDialog(getString(R.string.progress_message))
        pDialog.setCancelable(false)
        pDialog.show()
    }

    private fun initAdapter(it: List<Github>) {
        adapter = RepoListAdapter(this, it) {
            val model = (it as Github)
            val intent = Intent(this, RepoDetailActivity::class.java)
            intent.putExtra(OWNER, model.owner.login)
            intent.putExtra(IMAGE, model.owner.avatar_url)
            intent.putExtra(STAR_COUNT, model.stargazers_count)
            intent.putExtra(OPEN_ISSUE,model.open_issues)
            startActivity(intent)
        }
        repoRv.apply {
            layoutManager = LinearLayoutManager(this@RepoListActivity)
            adapter = this@RepoListActivity.adapter
        }
    }
}