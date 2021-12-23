package com.example.scrolablefragments.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.scrolablefragments.R




class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)
        textView = view.findViewById(R.id.textView)

        val sharedPreferences = requireActivity().getSharedPreferences("APP_PR", MODE_PRIVATE)
        val items = sharedPreferences.getString("notes", "")

        textView.text = items

        button.setOnClickListener {
            val item = editText.text.toString()
            val text = textView.text.toString()
            val result = "$item \n $text"

            textView.text = result

            sharedPreferences.edit()
                .putString("notes", result)
                .apply()
        }
    }
}