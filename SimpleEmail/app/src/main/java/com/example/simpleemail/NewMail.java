package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewMail extends AppCompatActivity {

    ImageView back_btn;
    TextView to_value, subject_value, compose_email_value,from_value;
    Button send_btn;
    MailDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mail);

        DataBase db = DataBase.getDbInstance(this.getApplicationContext());
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view ->{finish();});
        send_btn = findViewById(R.id.send_btn);
        from_value = findViewById(R.id.from_value);

        to_value = findViewById(R.id.to_value);
        subject_value = findViewById(R.id.subject_value);
        compose_email_value = findViewById(R.id.compose_email_value);


        send_btn.setOnClickListener(view -> {
            String to = to_value.getText().toString();
            String subject = subject_value.getText().toString();
            String compose = compose_email_value.getText().toString();
            String from = from_value.getText().toString();

            if(to == null || subject == null || compose ==null)
                Toast.makeText(this,"You must fill to,subject and compose fields",Toast.LENGTH_LONG).show();
            else{
                db.mailDao().insertMail(new Mail(subject,from,to,compose));
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

            }

        });



    }
}