package com.example.simpleemail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MailAdpater extends RecyclerView.Adapter<MailAdpater.ViewHolder> {

    List<Mail> mails;
    LayoutInflater layoutInflater;
    ClickInterface clickInterface;

    public MailAdpater(List<Mail> mails, Context context) {
        this.mails = mails;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MailAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= layoutInflater.inflate(R.layout.mail_object,parent,false);
         return new ViewHolder(view,clickInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull MailAdpater.ViewHolder holder, int i) {

        String first_letter = mails.get(i).getFirst_letter();
        holder.first_letter.setText(first_letter);

        String sender_value = mails.get(i).getSender();
        holder.sender_value.setText(sender_value);

        String subject_value = mails.get(i).getMail_title();
        holder.subject_value.setText(subject_value);

        String details_value = mails.get(i).getContent();
        holder.details_value.setText(details_value);

        String time_value = mails.get(i).getTime();
        holder.time_value.setText(time_value);
    }

    @Override
    public int getItemCount() {
        return mails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_letter,sender_value,subject_value,details_value,time_value;
        public ViewHolder(@NonNull View viewItem,ClickInterface clickInterface){
            super(viewItem);
            first_letter=viewItem.findViewById(R.id.first_letter);
            sender_value=viewItem.findViewById(R.id.sender_value);
            subject_value=viewItem.findViewById(R.id.subject_value);
            details_value=viewItem.findViewById(R.id.details_value);
            time_value=viewItem.findViewById(R.id.time_value);

            viewItem.setOnClickListener(v -> {
                if(clickInterface!=null){
                    int position= getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        clickInterface.OnItemClick(position);
                    }
                }
            });
        }
    }
}
