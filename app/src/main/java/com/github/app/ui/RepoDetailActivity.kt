package com.github.app.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.github.app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_repodetail.*

class RepoDetailActivity : AppCompatActivity() {

    companion object {
        const val OWNER = "OWNER"
        const val IMAGE = "IMAGE"
        const val STAR_COUNT = "STAR_COUNT"
        const val OPEN_ISSUE = "OPEN_ISSUE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repodetail)
        if (intent.extras != null) {
            owner_name.text = intent.extras!!.getString(OWNER)
            star_count.text = "Stars ${intent.extras!!.getInt(STAR_COUNT)}"
            issue_count.text = "Open Issues:  ${intent.extras!!.getInt(OPEN_ISSUE)}"
            val imageUrl = intent.extras!!.getString(IMAGE)
            if (!TextUtils.isEmpty(imageUrl)) {
                Picasso.get().load(imageUrl).into(owner_image)
            }
        }

    }

}