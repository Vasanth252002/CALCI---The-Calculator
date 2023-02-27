package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.ln

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textviews
        var work= findViewById<TextView>(R.id.working)
        var res= findViewById<TextView>(R.id.result)

        //Numbers
        val button1 = findViewById<Button>(R.id.numb1)
        button1.setOnClickListener{appendExpression("1",true)}
        val button2 = findViewById<Button>(R.id.numb2)
        button2.setOnClickListener{appendExpression("2",true)}
        val button3 = findViewById<Button>(R.id.numb3)
        button3.setOnClickListener{appendExpression("3",true)}
        val button4 = findViewById<Button>(R.id.numb4)
        button4.setOnClickListener{appendExpression("4",true)}
        val button5 = findViewById<Button>(R.id.numb5)
        button5.setOnClickListener{appendExpression("5",true)}
        val button6 = findViewById<Button>(R.id.numb6)
        button6.setOnClickListener{appendExpression("6",true)}
        val button7 = findViewById<Button>(R.id.numb7)
        button7.setOnClickListener{appendExpression("7",true)}
        val button8 = findViewById<Button>(R.id.numb8)
        button8.setOnClickListener{appendExpression("8",true)}
        val button9 = findViewById<Button>(R.id.numb9)
        button9.setOnClickListener{appendExpression("9",true)}
        val button0 = findViewById<Button>(R.id.numb0)
        button0.setOnClickListener{appendExpression("0",true)}
        val buttondot=findViewById<Button>(R.id.decimal)
        buttondot.setOnClickListener{appendExpression(".",true)}


        //operatrors
        val plus=findViewById<Button>(R.id.addition)
        val minus=findViewById<Button>(R.id.subtract)
        val multiply=findViewById<Button>(R.id.multiply)
        val div=findViewById<Button>(R.id.divide)
        val eq=findViewById<Button>(R.id.equal)
        val mod=findViewById<Button>(R.id.modulo)

        plus.setOnClickListener{appendExpression("+",false)}
        minus.setOnClickListener{appendExpression("-",false)}
        multiply.setOnClickListener{appendExpression("*",false)}
        div.setOnClickListener{appendExpression("/",false)}
        mod.setOnClickListener{appendExpression("%",false)}
        //miscellaneous

        val cl=findViewById<Button>(R.id.clear)
        val deleter=findViewById<Button>(R.id.delete)
        val equate=findViewById<Button>(R.id.equal)
        val log=findViewById<Button>(R.id.log2)


        cl.setOnClickListener{
            work.text=""
            res.text=""
        }
        deleter.setOnClickListener{
            val str=work.text.toString()
            if(str.isNotEmpty()){
                work.text=str.substring(0,str.length-1)
            }
            res.text=""
        }

        log.setOnClickListener {
            try{
                val expressions=ExpressionBuilder(work.text.toString()).build()
                val calculated=ln(expressions.evaluate())
                val longcalc=calculated.toLong()
                if(calculated==longcalc.toDouble())
                    res.text=calculated.toString()
                else
                    res.text=calculated.toString()

            }catch(e:Exception){
                res.text="Invalid Expression"
                work.text="Invalid Expression"
            }
        }

        equate.setOnClickListener {
            try{
                val expressions=ExpressionBuilder(work.text.toString()).build()
                val calculated=expressions.evaluate()
                val longcalc=calculated.toLong()
                if(calculated==longcalc.toDouble())
                    res.text=longcalc.toString()
                else
                    res.text=calculated.toString()

            }catch(e:Exception){
                res.text="Invalid Expression"
                work.text="Invalid Expression"
            }
        }

    }
    fun appendExpression(string:String, canClear:Boolean){
        var work= findViewById<TextView>(R.id.working)
        var res= findViewById<TextView>(R.id.result)
        if(res.text.isNotEmpty()){
            work.text=""
        }
        if(canClear){
            res.setText("")
            work.append(string)

        }else{
            work.append(res.text)
            work.append(string)
            res.text=""
        }
    }
}