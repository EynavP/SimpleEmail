package com.example.simpleemail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReplayAdapter extends RecyclerView.Adapter<ReplayAdapter.ViewHolder>{

    List<Replay> replays;
    LayoutInflater layoutInflater;

    public ReplayAdapter(List<Replay> replays, Context context) {
        this.replays = replays;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReplayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.replay_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReplayAdapter.ViewHolder holder, int i) {

        String comment=replays.get(i).getComment();
        holder.comment.setText(comment);
    }

    @Override
    public int getItemCount() {
        return replays.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            comment=itemView.findViewById(R.id.TVcomment);
        }
    }
}
