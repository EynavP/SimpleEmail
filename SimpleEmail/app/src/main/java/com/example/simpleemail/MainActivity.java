package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   {

    RecyclerView recyclerView;
    MailAdpater mailAdpater;
    List<Mail> mails;
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

    }

    private void GetMails() {
        mails.add(new Mail("First Message","Eynav","Hello, wolcome to your mail"));
    }


}