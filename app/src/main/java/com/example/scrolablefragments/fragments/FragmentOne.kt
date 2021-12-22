package com.example.scrolablefragments.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.scrolablefragments.R




class FragmentOne : Fragment(R.layout.fragment_one) {
    private lateinit var editTextNotes: EditText
    private lateinit var buttonAdd: Button
    private lateinit var textViewNotes: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextNotes = view.findViewById(R.id.editTextNotes)
        buttonAdd = view.findViewById(R.id.buttonAdd)
        textViewNotes = view.findViewById(R.id.textViewNotes)

        val sharedPreferences = requireActivity().getSharedPreferences("APP_PR", MODE_PRIVATE)
        val notes = sharedPreferences.getString("notes", "")

        textViewNotes.text = notes

        buttonAdd.setOnClickListener {
            val note = editTextNotes.text.toString()
            val text = textViewNotes.text.toString()
            val result = "$note \n $text"

            textViewNotes.text = result

            sharedPreferences.edit()
                .putString("notes", result)
                .apply()
        }
    }
}