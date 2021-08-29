package com.nepplus.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        //복귀 버튼이 눌리면 => 메인화면으로 이동.


        returnToMainBtn.setOnClickListener {

            //다른 화면으로 이동하기가 눌리면?

            //어디서 -> 어느 화면으로 이동할건지 정보 (Intent) 명시. => 변수에 담아서 저장.

            val myIntent = Intent(this, MainActivity::class.java)

            // 실제 이동 시키자.
            startActivity(myIntent)
        }
    }
}