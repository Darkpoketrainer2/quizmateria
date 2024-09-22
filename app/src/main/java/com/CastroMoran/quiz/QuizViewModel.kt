package com.CastroMoran.quiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_jalisco,answer = true) ,
        Question(R.string.question_ameca,answer = true),
        Question(R.string.question_zacatecas,answer = false),
        Question(R.string.question_tlaxcala,answer = false)
    )
    private var currentIndex:Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY,value)

    val currentQuestionAnswer:Boolean
        get()= questionBank[currentIndex].answer
    val currentQuestionText:Int
        get()=questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    fun moveToPrev(){
        if(currentIndex == 0)
            currentIndex = questionBank.size - 1
        else
            currentIndex = (currentIndex - 1) % questionBank.size
    }
    }