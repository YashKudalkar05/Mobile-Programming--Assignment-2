package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.ActivityMood
import com.example.assignment2.R

class ActivitiesAdapter(private val activitiesList: List<ActivityMood>) :
    RecyclerView.Adapter<ActivitiesAdapter.ActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activityMood = activitiesList[position]
        holder.activityName.text = activityMood.activityName
        holder.activityType.text = activityMood.activityType
        holder.mood.text = activityMood.mood
    }

    override fun getItemCount(): Int {
        return activitiesList.size
    }

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityName: TextView = itemView.findViewById(R.id.textViewActivityName)
        val activityType: TextView = itemView.findViewById(R.id.textViewActivityType)
        val mood: TextView = itemView.findViewById(R.id.textViewMood)
    }
}
