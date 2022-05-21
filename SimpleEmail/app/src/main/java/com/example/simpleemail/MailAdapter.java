package com.example.simpleemail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MailAdapter extends BaseAdapter {

    main_List_fragment.SelectionListener listener;
    private List<Mail> Mails;

    public MailAdapter(List<Mail> mails, main_List_fragment.SelectionListener listener){
        this.Mails = mails;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return Mails.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_object, parent, false);

            convertView.setTag(new ViewHolder(convertView));
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();

        Mail mail = Mails.get(position);

   //     holder.TV_mail_title.setText(mail.getMail_title());
        holder.Tv_first_letter.setText(mail.getFirst_letter());
        holder.Tv_sender_value.setText(mail.getSender());
        holder.Tv_time_value.setText(mail.getTime());
//        holder.mail_content.setText(mail.getContent());

        return convertView;
    }

    class ViewHolder{

        TextView TV_mail_title;
        TextView Tv_first_letter;
        TextView Tv_sender_value;
        TextView Tv_time_value;
        TextView mail_content;


        public ViewHolder(View view) {
            TV_mail_title = view.findViewById(R.id.mail_title);
            Tv_first_letter = view.findViewById(R.id.first_letter);
            Tv_sender_value = view.findViewById(R.id.sender_value);
            Tv_time_value = view.findViewById(R.id.time_value);
            mail_content = view.findViewById(R.id.mail_content);
        }
    }
}





