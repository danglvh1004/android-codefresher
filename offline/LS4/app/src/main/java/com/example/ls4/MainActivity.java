package com.example.ls4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvTeams;
    private List<FootballTeam> teamList = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvTeams = findViewById(R.id.rcv_listItem);

        setTeamData();

        adapter = new MyAdapter(teamList, getApplicationContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        rcvTeams.setLayoutManager(linearLayoutManager);
        rcvTeams.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //them, sua, xoa item trong recycleview
                teamList.add(0, new FootballTeam("T&T Ha Noi", "V-League", 1960));

                adapter.notifyDataSetChanged();
            }
        }, 10000);
    }

    private void setTeamData() {
        teamList.add(new FootballTeam("Manchester United", "English Premier League", 1878));
        teamList.add(new FootballTeam("Arsenal", "English Premier League", 1886));
        teamList.add(new FootballTeam("Liverpool", "English Premier League", 1892));
        teamList.add(new FootballTeam("Juventus", "Serie A", 1897));
        teamList.add(new FootballTeam("Real Madrid", "La Liga", 1902));
        teamList.add(new FootballTeam("Bayern Munich", "Bundesliga", 1900));
        teamList.add(new FootballTeam("Bayern Munich", "Bundesliga", 1900));
    }
}