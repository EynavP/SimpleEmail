package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Specific_mail extends AppCompatActivity {

    Mail mail;
    TextView mail_title,first_letter,sender_value,time_value,mail_content,TVReplay;
    ImageView backBtn;
    ImageButton BtnReplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_mail);
        mail =(Mail) getIntent().getSerializableExtra("mail");

        mail_title = findViewById(R.id.mail_title);
        first_letter = findViewById(R.id.first_letter);
        sender_value = findViewById(R.id.sender_value);
        time_value = findViewById(R.id.time_value);
        mail_content = findViewById(R.id.mail_content);
        TVReplay = findViewById(R.id.TVReplay);


        mail_title.setText(mail.getMail_title());
        first_letter.setText(mail.getFirst_letter());
        sender_value.setText(mail.getSender());
        time_value.setText(mail.getTime());
        mail_content.setText(mail.getContent());

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(view -> finish());

        BtnReplay = findViewById(R.id.BtnReplay);
        BtnReplay.setOnClickListener(view->{
            if(TVReplay.getText().toString()!=null)
                mail.addReplay(TVReplay.getText().toString());
        });


    }
}