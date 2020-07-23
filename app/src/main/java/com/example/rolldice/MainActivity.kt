package com.example.rolldice

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var text_roll:TextView
    lateinit var button_dice:Button
    lateinit var animationRoll:LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_roll=findViewById(R.id.textView_number)
        button_dice=findViewById(R.id.Button_roll)
        animationRoll=findViewById(R.id.dice)
        animationRoll.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
              hideDice()
                val randomNumber =(1..6).random()
                text_roll.text= randomNumber.toString()
                animationRoll.playAnimation()

            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {
            }


        })

    }

    fun rollDice(view: View) {
        showDice()
        animationRoll.playAnimation()

    }
    private fun showDice(){
        animationRoll.visibility=View.VISIBLE
        text_roll.visibility=View.GONE
        button_dice.isEnabled=false
    }
    private  fun hideDice(){
        animationRoll.visibility=View.GONE
        text_roll.visibility=View.VISIBLE
        button_dice.isEnabled=true
    }
}