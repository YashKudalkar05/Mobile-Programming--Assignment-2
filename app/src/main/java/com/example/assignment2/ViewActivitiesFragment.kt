package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.ActivitiesAdapter
import com.example.assignment2.LogActivityFragment
import com.example.assignment2.R

class ViewActivitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ActivitiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_activities, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewActivities)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ActivitiesAdapter(LogActivityFragment.activitiesList)
        recyclerView.adapter = adapter

        return view
    }
}
