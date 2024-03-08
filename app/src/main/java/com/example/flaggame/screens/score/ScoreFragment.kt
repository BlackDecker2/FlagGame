package com.example.flaggame.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.flaggame.R
import com.example.flaggame.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)

        val scoreArgs = ScoreFragmentArgs.fromBundle(requireArguments())
        binding.displayResult.text = "Tu puntaje es ${scoreArgs.score} puntos de 10"

        binding.playAgain.setOnClickListener { view ->
            view.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToEasyFragment())
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            view?.findNavController()?.navigate(ScoreFragmentDirections.actionScoreFragmentToEasyFragment())
        }

        return binding.root
    }
}
