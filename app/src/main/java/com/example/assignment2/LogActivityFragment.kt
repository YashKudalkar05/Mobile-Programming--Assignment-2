package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assignment2.R

class LogActivityFragment : Fragment() {

    private lateinit var editTextActivityName: EditText
    private lateinit var spinnerActivityType: Spinner
    private lateinit var buttonSaveActivity: Button

    companion object {
        val activitiesList = mutableListOf<ActivityMood>()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_activity, container, false)
        editTextActivityName = view.findViewById(R.id.editTextActivityName)
        spinnerActivityType = view.findViewById(R.id.spinnerActivityType)
        buttonSaveActivity = view.findViewById(R.id.buttonSaveActivity)

        buttonSaveActivity.setOnClickListener {
            val activityName = editTextActivityName.text.toString()
            val activityType = spinnerActivityType.selectedItem.toString()
            // Check if the input is valid

            if (activityName.isEmpty()) {
                Toast.makeText(context, "Please enter an activity name", Toast.LENGTH_SHORT).show()
            }
            else {
                val activityMood = ActivityMood(activityName, activityType, "")
                activitiesList.add(activityMood)

                Toast.makeText(
                    context,
                    "Activity saved: $activityName - $activityType",
                    Toast.LENGTH_SHORT
                ).show()

                // Clear the input fields
                editTextActivityName.text.clear()
                spinnerActivityType.setSelection(0)

                TrackMoodDialogFragment().show(parentFragmentManager, "TrackMoodDialog")
            }
        }

        return view
    }

}
