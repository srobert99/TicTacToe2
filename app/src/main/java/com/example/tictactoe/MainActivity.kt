package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var table=arrayOf(intArrayOf(0,0,0),intArrayOf(0,0,0),intArrayOf(0,0,0))
    private var sign=1
    private var scorX=0
    private var scorO=0
    private lateinit var xScore:TextView
    private lateinit var oScore:TextView
    private lateinit var poz11: TextView
    private lateinit var poz12: TextView
    private lateinit var poz13: TextView
    private lateinit var poz21: TextView
    private lateinit var poz22: TextView
    private lateinit var poz23: TextView
    private lateinit var poz31: TextView
    private lateinit var poz32: TextView
    private lateinit var poz33: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)
        var endButton=findViewById<Button>(R.id.end_button)

        xScore=findViewById(R.id.scorJucX)
        oScore=findViewById(R.id.scorJucO)
        poz11=findViewById(R.id.poz11)
        poz12=findViewById(R.id.poz12)
        poz13=findViewById(R.id.poz13)
        poz21=findViewById(R.id.poz21)
        poz22=findViewById(R.id.poz22)
        poz23=findViewById(R.id.poz23)
        poz31=findViewById(R.id.poz31)
        poz32=findViewById(R.id.poz32)
        poz33=findViewById(R.id.poz33)

        poz11.setOnClickListener { clk(poz11,0,0) }
        poz12.setOnClickListener { clk(poz12,0,1) }
        poz13.setOnClickListener { clk(poz13,0,2) }
        poz21.setOnClickListener { clk(poz21,1,0) }
        poz22.setOnClickListener { clk(poz22,1,1) }
        poz23.setOnClickListener { clk(poz23,1,2) }
        poz31.setOnClickListener { clk(poz31,2,0) }
        poz32.setOnClickListener { clk(poz32,2,1) }
        poz33.setOnClickListener { clk(poz33,2,2) }
        endButton.setOnClickListener{endGame()}

    }

    fun clk(x: TextView,l:Int,c:Int){
        if(table[l][c]==0) {
            if (sign == 1) {
                x.setText("X")
                table[l][c] = 1
                if (verif(l, c, sign) == 1) {
                    scorX++
                    xScore.text = getString(R.string.jucator_x) + "$scorX"
                    resetGame()

                } else {
                    sign = 2
                }

            } else {
                x.setText("O")
                table[l][c] = 2
                if (verif(l, c, sign) == 1) {
                    scorO++
                    oScore.text = getString(R.string.jucator_o) + "$scorO"
                    resetGame()
                }
                sign = 1
            }
        }
    }

    fun verif(l:Int,c:Int,sign:Int):Int{
        var ok=0
        if(table[0][c]==sign && table[1][c]==sign && table[2][c]==sign){

            return 1
        }
        if(table[l][0]==sign && table[l][1]==sign && table[l][2]==sign){

            return 1
        }
        if(table[0][2]==sign && table[1][1]==sign && table[2][0]==sign){

            return 1
        }
        if(table[0][0]==sign && table[1][1]==sign && table[2][2]==sign){

            return 1
        }
        for(l in 0..2){
            for(c in 0..2){
                if(table[l][c]==0){
                    ok=1
                }
            }
        }
        if(ok==0){
            resetGame()
        }
        return 0

    }

    fun resetGame(){
        poz11.text=""
        poz12.text=""
        poz13.text=""
        poz21.text=""
        poz22.text=""
        poz23.text=""
        poz31.text=""
        poz32.text=""
        poz33.text=""
        for(l in 0..2){
            for(c in 0..2){
                table[l][c]=0
            }
        }

    }

    fun endGame(){
        if(scorO>scorX){
            sign=2
        }else if(scorO<scorX){
            sign=1;
        }else{
            sign=0
        }
        val intent= Intent(this@MainActivity,FinalScreen::class.java)
        intent.putExtra("winner",sign)
        finish()
        startActivity(intent)
    }
}
