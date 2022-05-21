package com.example.simpleemail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class main_List_fragment extends ListFragment implements AdapterView.OnItemClickListener{

    List<Mail> mails;
    Fragment mailDetails;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((SelectionListener) getActivity()).onItemSeleceted(mails.get(position));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ((SelectionListener) getActivity()).onItemSeleceted(mails.get(position));
    }
    public interface SelectionListener{
        void onItemSeleceted(Mail mail);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.mail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mails = generateMails();
        MailAdapter adapter = new MailAdapter(mails, (SelectionListener) getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    private List<Mail> generateMails() {
        List<Mail> mails = new ArrayList<>();

        mails.add(new Mail("Hello world","Eynav","this is your first message"));
        return mails;
    }
}
