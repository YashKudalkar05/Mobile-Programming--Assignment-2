package com.example.assignment2

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import com.example.assignment2.R
import com.example.assignment2.TrackMoodDialogFragment
import com.example.assignment2.LogActivityFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_log_activity -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, LogActivityFragment())
                }
                true
            }
            R.id.action_track_mood -> {
                TrackMoodDialogFragment().show(supportFragmentManager, "TrackMoodDialog")
                true
            }R.id.action_view_activities -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, ViewActivitiesFragment())
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
