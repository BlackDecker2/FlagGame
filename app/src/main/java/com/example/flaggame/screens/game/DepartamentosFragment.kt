package com.example.flaggame.screens.game

import ConstantsDepartamentos
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.flaggame.QuestionDepartamentos
import com.example.flaggame.R
import com.example.flaggame.databinding.FragmentGameDepartamentoBinding

class DepartamentosFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentGameDepartamentoBinding

    private lateinit var mQuestionsList: ArrayList<QuestionDepartamentos>
    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mCurrentPosition: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_departamento, container, false)
        mQuestionsList = ConstantsDepartamentos.getQuestionDepartamento()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
        setQuestion()
        return binding.root
    }

    private fun setQuestion() {
        if (mCurrentPosition in 1..mQuestionsList.size) {
            val question = mQuestionsList[mCurrentPosition - 1]
            with(binding) {
                tvQuestion.text = question.question
                imageView.setImageResource(question.image)
                tvOptionOne.text = question.optionOne
                tvOptionTwo.text = question.optionTwo
                tvOptionThree.text = question.optionThree
                pb.progress = mCurrentPosition
                tvProgress.text = "$mCurrentPosition/${binding.pb.max}"
                defaultAppearance()
            }
            if (mCurrentPosition == mQuestionsList.size) {
                binding.btnSubmit.text = "Juego Finalizado"
            } else {
                binding.btnSubmit.text = "Enviar"
            }
        } else {
            Log.e("DepartamentoFragment", "Invalid current position: $mCurrentPosition")
        }
    }

    private fun defaultAppearance() {
        val options = arrayListOf<TextView>(binding.tvOptionOne, binding.tvOptionTwo, binding.tvOptionThree)
        options.forEach { option ->
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> selectOptionAndCheckAnswer(binding.tvOptionOne, 1)
            R.id.tv_optionTwo -> selectOptionAndCheckAnswer(binding.tvOptionTwo, 2)
            R.id.tv_optionThree -> selectOptionAndCheckAnswer(binding.tvOptionThree, 3)
            R.id.btnSubmit -> submitAnswer()
        }
    }

    private fun selectOptionAndCheckAnswer(tv: TextView, selectedPosition: Int) {
        if (mSelectedPosition != 0) {
            Toast.makeText(context, "Ya has seleccionado una opción", Toast.LENGTH_SHORT).show()
            return
        }
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_option_border_bg)
        mSelectedPosition = selectedPosition
        val question = mQuestionsList[mCurrentPosition - 1]

        val options = arrayListOf<TextView>(binding.tvOptionOne, binding.tvOptionTwo, binding.tvOptionThree)
        val correctAnswer = question.correctAnswer
        val selectedOption = mSelectedPosition

        options.forEachIndexed { index, option ->
            if (index + 1 == correctAnswer) {
                option.background = ContextCompat.getDrawable(requireContext(), R.drawable.correct_option_border_bg)
            } else if (index + 1 == selectedOption) {
                option.background = ContextCompat.getDrawable(requireContext(), R.drawable.wrong_option_border_bg)
            }
        }
    }

    private fun submitAnswer() {
        if (mSelectedPosition == 0) {
            Toast.makeText(context, "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show()
            return
        }
        val question = mQuestionsList[mCurrentPosition - 1]
        val correctAnswer = question.correctAnswer
        val selectedOption = mSelectedPosition

        if (correctAnswer == selectedOption) {
            mCorrectAnswer++
        }
        mCurrentPosition++
        if (mCurrentPosition <= mQuestionsList.size) {
            setQuestion()
        } else {
            val action = DepartamentosFragmentDirections.actionDepartamentosFragmentToScoreFragment()
            val nameOfPlayer by navArgs<DepartamentosFragmentArgs>()
            action.score = mCorrectAnswer
            action.name = nameOfPlayer.name
            findNavController().navigate(action)
        }
        mSelectedPosition = 0
    }
}
