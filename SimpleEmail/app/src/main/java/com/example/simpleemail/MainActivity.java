package com.example.simpleemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements main_List_fragment.SelectionListener  {

    DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsFragment = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
    }

    @Override
    public void onItemSeleceted(Mail mail) {

        if (detailsFragment == null){
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra("position", mail);
            startActivity(intent);
        }
        else {
            detailsFragment.setDetails(mail);
        }

    }
}