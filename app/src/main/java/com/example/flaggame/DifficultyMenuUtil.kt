package com.example.flaggame

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.flaggame.Difficulty
import com.example.flaggame.databinding.FragmentTitleBinding
/**
object DifficultyMenuUtil {

    fun setupDifficultyMenu(fragment: Fragment, binding: FragmentTitleBinding) {
        val difficultyOptions = arrayOf("Fácil", "Intermedio", "Difícil")
        val adapter = ArrayAdapter(fragment.requireContext(), android.R.layout.simple_spinner_item, difficultyOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.wheelOptions.adapter = adapter

        binding.wheelOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedDifficulty = when (position) {
                    0 -> Difficulty.EASY
                    1 -> Difficulty.MEDIUM
                    2 -> Difficulty.HARD
                    else -> null
                }
                onDifficultySelected(fragment, selectedDifficulty, binding)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        binding.startBtn.setOnClickListener {
            val playerName = binding.etName.text.toString()
            val selectedDifficulty = binding.wheelOptions.selectedItemPosition
            if (playerName.isNotEmpty()) {
                onDifficultySelected(fragment, Difficulty.values()[selectedDifficulty], binding)
            } else {
                Toast.makeText(fragment.requireContext(), "Ingresa tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onDifficultySelected(fragment: Fragment, difficulty: Difficulty?, binding: FragmentTitleBinding) {
        if (difficulty != null) {
            if (difficulty == Difficulty.EASY) {
                val action = TitleFragmentDirections.actionTitleFragmentToEasyFragment()
                action.name = binding.etName.text.toString()
                fragment.findNavController().navigate(action)
            } else if (difficulty == Difficulty.HARD) {
                val action = TitleFragmentDirections.actionTitleFragmentToDepartamentosFragment()
                action.name = binding.etName.text.toString()
                fragment.findNavController().navigate(action)
            } else {
                val action = TitleFragmentDirections.actionTitleFragmentToGameFragment(difficulty.ordinal)
                action.name = binding.etName.text.toString()
                fragment.findNavController().navigate(action)
            }
        }
    }
}
 */
