package com.example.tictactoe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_final_screen)
        var intent=intent
        val winner=intent.getIntExtra("winner",99)
        var finalText=findViewById<TextView>(R.id.winner_message)
        if(winner==0){
            finalText.setText("DRAW")
        }else {
            finalText.setText("Player $winner wins")
        }
    }
}