package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Specific_mail extends AppCompatActivity {

    Mail mail;
    TextView mail_title,first_letter,sender_value,time_value,mail_content;
    EditText TVReplay;
    ImageView backBtn;
    ImageButton BtnReplay;
    RecyclerView RvReplays_list;
    List<Replay> replays;
    ReplayAdapter ReplayAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_mail);
        mail =(Mail) getIntent().getSerializableExtra("mail");
        DataBase db = DataBase.getDbInstance(this.getApplicationContext());

        mail_title = findViewById(R.id.mail_title);
        first_letter = findViewById(R.id.first_letter);
        sender_value = findViewById(R.id.sender_value);
        time_value = findViewById(R.id.time_value);
        mail_content = findViewById(R.id.mail_content);
        TVReplay = findViewById(R.id.TVReplay);
        RvReplays_list = findViewById(R.id.RvReplays_list);

        mail_title.setText(mail.getMail_title());
        first_letter.setText(mail.getFirst_letter());
        sender_value.setText(mail.getSender());
        time_value.setText(mail.getTime());
        mail_content.setText(mail.getContent());

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(view -> finish());

        replays=db.replayDao().getAllReplays(mail.getId());
        RvReplays_list=findViewById(R.id.RvReplays_list);
        RvReplays_list.setLayoutManager(new LinearLayoutManager(this));
        ReplayAdpater= new ReplayAdapter(replays,this);
        RvReplays_list.setAdapter(ReplayAdpater);

        BtnReplay = findViewById(R.id.BtnReplay);
        BtnReplay.setOnClickListener(view->{
            if(TVReplay.getText().toString()!=null){
                db.replayDao().insertReplay(new Replay(mail.getId(),TVReplay.getText().toString()));
                Toast.makeText(this,"Add replay Success",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}