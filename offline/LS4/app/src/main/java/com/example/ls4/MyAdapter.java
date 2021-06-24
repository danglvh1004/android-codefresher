package com.example.ls4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public List<FootballTeam> teamList;
    Context ctx;

    public MyAdapter(List<FootballTeam> teamList, Context ctx) {
        this.teamList = teamList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAdapter.MyViewHolder holder, int position) {
        FootballTeam footballTeam = teamList.get(position);
        if (footballTeam == null) {
            return;
        }
        holder.tvName.setText(footballTeam.getName());
        holder.tvLeague.setText(footballTeam.getLeague());
        holder.tvYear.setText(String.valueOf(footballTeam.getYearEstablished()));
    }

    @Override
    public int getItemCount() {
        if (teamList != null) {
            return teamList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;
        TextView tvLeague;
        TextView tvYear;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvLeague = itemView.findViewById(R.id.tvLeague);
            tvYear = itemView.findViewById(R.id.tv_year);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            FootballTeam footballTeam = teamList.get(position);
            Toast.makeText(ctx, footballTeam.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
