package com.example.flaggame.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flaggame.databinding.FragmentTitleBinding
import com.example.flaggame.Difficulty
import com.example.flaggame.R

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private var selectedDifficulty: Difficulty? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(inflater, container, false)

        // Configuración del menú desplegable de dificultad
        val difficultyOptions = arrayOf("Fácil", "Intermedio", "Difícil")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, difficultyOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.wheelOptions.adapter = adapter

        // Manejar la selección del menú desplegable
        binding.wheelOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedDifficulty = when (position) {
                    0 -> Difficulty.EASY
                    1 -> Difficulty.MEDIUM
                    2 -> Difficulty.HARD
                    else -> null
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar el caso de que no se haya seleccionado nada
            }
        }

        // Manejar el clic del botón de inicio
        binding.startBtn.setOnClickListener {
            val playerName = binding.etName.text.toString()
            if (playerName.isNotEmpty() && selectedDifficulty != null) {
                startGameFragment(selectedDifficulty!!, playerName)
            } else {
                Toast.makeText(context, "Ingresa tu nombre y selecciona una dificultad", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun startGameFragment(difficulty: Difficulty, playerName: String) {
        if (difficulty == Difficulty.EASY) {
            // Navegar a EasyFragment
            findNavController().navigate(R.id.action_titleFragment_to_easyFragment2)
        } else {
            // Si no es fácil, navegar a GameFragment
            val action = TitleFragmentDirections.actionTitleFragmentToGameFragment(difficulty.ordinal)
            action.name = playerName
            findNavController().navigate(action)
        }
    }

}
