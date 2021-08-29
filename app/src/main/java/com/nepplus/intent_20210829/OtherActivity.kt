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



            val myIntent = Intent(this, MainActivity::class.java)

            // 실제 이동 시키자.
            startActivity(myIntent)

            //지금 보고있는 다른화면을 종료 처리
            finish()
        }
    }
}