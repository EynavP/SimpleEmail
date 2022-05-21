package com.example.simpleemail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    TextView TV_mail_title;
    TextView Tv_first_letter;
    TextView Tv_sender_value;
    TextView Tv_time_value;
    TextView mail_content;
    ImageView replay_btn;
    ImageView back_btn;

    public DetailsFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_email_details, container, false);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TV_mail_title = view.findViewById(R.id.mail_title);
        Tv_first_letter = view.findViewById(R.id.first_letter);
        Tv_sender_value = view.findViewById(R.id.sender_value);
        Tv_time_value = view.findViewById(R.id.time_value);
        mail_content = view.findViewById(R.id.mail_content);
        replay_btn = view.findViewById(R.id.replay_btn);
        back_btn = view.findViewById(R.id.back_btn);

        view.setVisibility(View.INVISIBLE);
    }

    public void setDetails(Mail mail) {
        TV_mail_title.setText(mail.getMail_title());
        Tv_first_letter.setText(mail.getFirst_letter());
        Tv_sender_value.setText(mail.getSender());
        Tv_time_value.setText(mail.getTime());
        mail_content.setText(mail.getContent());

        if (!getView().isShown())
            getView().setVisibility(View.VISIBLE);
    }
}
