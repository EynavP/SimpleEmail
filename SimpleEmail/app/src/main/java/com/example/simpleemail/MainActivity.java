package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickInterface  {

    RecyclerView recyclerView;
    MailAdpater mailAdpater;
    List<Mail> mails;
    ImageView IvAdd_mail_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mails=new ArrayList<>();
        GetMails();
        recyclerView=findViewById(R.id.Rvmails_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mailAdpater= new MailAdpater(mails,this);
        recyclerView.setAdapter(mailAdpater);
        IvAdd_mail_icon = findViewById(R.id.IvAdd_mail_icon);

        IvAdd_mail_icon.setOnClickListener(view -> {
            Intent intent = new Intent(this,NewMail.class);
            startActivity(intent);
        });

    }

    private void GetMails() {
        mails.add(new Mail("First Message","Eynav","Hello, wolcome to your mail"));
    }


    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this,Specific_mail.class);
        intent.putExtra("mail",mails.get(position));
        startActivity(intent);
    }
}