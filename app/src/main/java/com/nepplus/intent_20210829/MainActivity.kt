package com.nepplus.intent_20210829

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_FOR_NICKNAME = 1004
    val REQ_FOR_PHONE_NUM = 1005
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



           callBtn.setOnClickListener {

               // 문법상 틀린게 없어도 앱이 죽는다.
               // 권환 획든해야 정상동작.

               val inputPhoneNum = phoneNumEdt.text.toString()
               val myUri = Uri.parse("tel:$({inputPhonum}")
               val myIntent = Intent(Intent.ACTION_CALL, myUri)
               startActivity(myIntent)

           }

        // 전화 걸기 (DIAL)  Intent 활용 예시.
        dialBtn.setOnClickListener {
            //전화번호를 받아오자.
            val inputPhoneNum = phoneNumEdt.text.toString()

            //어디에 전화를 걸지 알려주는 정보 (Uri) 로 가공.
            val myUri = Uri.parse("tel:${inputPhoneNum}")  //tel:입력한 번호 형태로 가공.

        // 전화 화면으로 이동 + 어디에 걸지 (Uri) 조합 -> Intent

             val myIntent = Intent( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)

        }

        editNicknameBtn.setOnClickListener {

            //닉네임 변경 화면으로 이동.

            //단순이동x  새 닉네임을 받아오기 위한 왕복 이동.

            //intent 변수 만드는 과정동일.

            val myIntent = Intent(this, EditNicknameActivity::class.java)

            // 데이터(닉네임)를 받아오기 윟나 왕복 이동 명시.

            startActivityForResult(myIntent,REQUEST_CODE_FOR_NICKNAME )

        }


        sendMessageBtn.setOnClickListener {

            // 메세지 보내기가 눌리면?

            // 입력한 내용이 어떻게 되는지 변수에 저장.

            val inputContent = messageEdt.text.toString()


            // 메세지 조회화면으로 (입력한 내용을 들고) 이동.

            val myIntent = Intent(this, ViewMessageActivity::class.java)

            //string을 첨부
            myIntent.putExtra("inputMessage", inputContent)
            //int를 첨부
            myIntent.putExtra("number",2021)

            startActivity(myIntent)

        }

        moveToOtherBtn.setOnClickListener {

            //다른 화면으로 이동하기가 눌리면?

            //어디서 -> 어느 화면으로 이동할건지 정보 (Intent) 명시. => 변수에 담아서 저장.

            val myIntent = Intent( this, OtherActivity::class.java )

            // 실제 이동 시키자.
            startActivity( myIntent )










        }
        //    startAcivityForResult를 통해서 이동화면에서 -> ap인화면으로 복귀하면 실행시켜주는 함수.
    //    완료를 누르건, 최소를 누르건 무조건 실행되는 함수 -> 이 두 상황을 구별하자.



            }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: data?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    // 1.requestCode : int ->startActivityForResult에 넣어준 숫자값이 뭐였는가?
    //     => 어디를 다녀온건지 알려주는 역할.
    //    =>이번에 다녀온게, 닉네임을 받으러 다녀온건지? 상황에 맞는코드.


    if (requestCode == REQUEST_CODE_FOR_NICKNAME)


    //  2.  resultCode: Int -> 돌아올때, RESULT_OK를 갖고왔는지, 취소값으로 갖고왓는지
    //    =>확인을 누른게 맞는지 구별의 근거자료.

    if (resultCode == RESULT_OK) {

        // 닉네임 ->  OK 까지 한 상황.
        //   받아온 닉네임값을 텍스트뷰에 반영.
        //  data변수에 ->  resultIntent가 담겨있는상황.
        // -> 갖고있는 string 하나를 꺼내라고하자.

        val newNickname = data?.getStringExtra("newNickname")
        nicknameTxt.text = newNickname


    }


}