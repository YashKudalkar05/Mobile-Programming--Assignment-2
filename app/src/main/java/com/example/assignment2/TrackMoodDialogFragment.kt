package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.example.assignment2.R

class TrackMoodDialogFragment : DialogFragment() {

    private lateinit var radioGroupMood: RadioGroup
    private lateinit var buttonSaveMood: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_track_mood, container, false)
        radioGroupMood = view.findViewById(R.id.radioGroupMood)
        buttonSaveMood = view.findViewById(R.id.buttonSaveMood)

        buttonSaveMood.setOnClickListener {
            saveMood()
        }

        return view
    }

    private fun saveMood() {
        if(LogActivityFragment.activitiesList.isNotEmpty()){
            if (LogActivityFragment.activitiesList.last().mood != "") {
            Toast.makeText(context, "You need to log an activity", Toast.LENGTH_SHORT).show()
            return
            }

            else{
            val selectedMood = when (radioGroupMood.checkedRadioButtonId) {
                R.id.radioHappy -> "Happy"
                R.id.radioNeutral -> "Neutral"
                R.id.radioSad -> "Sad"
                else -> ""
            }
                LogActivityFragment.activitiesList.last().mood = selectedMood
                Toast.makeText(context, "Mood saved: $selectedMood", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(context, "You need to log an activity first", Toast.LENGTH_SHORT).show()
        }

        dismiss()
    }
}
