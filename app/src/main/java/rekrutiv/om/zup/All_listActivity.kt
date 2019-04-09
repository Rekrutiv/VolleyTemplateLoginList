package rekrutiv.om.zup
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import kotlinx.android.synthetic.main.activity_all_list.*



class All_listActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_list)

      // val s1:String = intent.getStringExtra("likes")
//        val s2:String = intent.getStringExtra("user")
         tv_id.setText(intent.getStringExtra("likes"))
         tv_creator_detail.setText(intent.getStringExtra("views"))
         tv_like_detail.setText(intent.getStringExtra("user"))
         tv_url.setText(intent.getStringExtra("pageURL"))
         tv_client_contacts.setText(intent.getStringExtra("client_contacts"))
                 //+intent.getStringExtra("client_notes").toString())



    }
}
