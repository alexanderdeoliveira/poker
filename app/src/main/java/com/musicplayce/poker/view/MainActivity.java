package com.musicplayce.poker.view;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.musicplayce.poker.interfaces.GameContract;
import com.musicplayce.poker.R;
import com.musicplayce.poker.model.Player;
import com.musicplayce.poker.presenter.GamePresenter;
import com.plattysoft.leonids.ParticleSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GameContract.GameView {

    private GameContract.UserActionsListener userActionsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userActionsListener = new GamePresenter(this);
        initViews();
    }

    private void initViews() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userActionsListener.initGame();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public void showHands(Player player1, Player player2) {
        TextView tvNamePlayer1 = findViewById(R.id.tv_name_player1);
        tvNamePlayer1.setText(player1.getName());

        CardAdapter adapter1 = new CardAdapter(this, player1.getHand().getCards());
        RecyclerView rvHandPlayer1 = findViewById(R.id.rv_hand_player1);
        rvHandPlayer1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvHandPlayer1.setAdapter(adapter1);

        TextView tvNamePlayer2 = findViewById(R.id.tv_name_player2);
        tvNamePlayer2.setText(player2.getName());

        CardAdapter adapter2 = new CardAdapter(this, player2.getHand().getCards());
        RecyclerView rvHandPlayer2 = findViewById(R.id.rv_hand_player2);
        rvHandPlayer2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvHandPlayer2.setAdapter(adapter2);

    }

    @Override
    public void showWinner(Player playerWinner) {
        TextView tvWinner = findViewById(R.id.tv_winner);
        tvWinner.setText(playerWinner.getName());

        LinearLayout layoutWinner = findViewById(R.id.layout_winner);
        layoutWinner.setVisibility(View.VISIBLE);

        new ParticleSystem(this, 500, R.drawable.star_pink, 800)
        .setScaleRange(0.7f, 1.3f)
        .setSpeedRange(0.1f, 0.25f)
        .setRotationSpeedRange(90, 180)
        .setFadeOut(200, new AccelerateInterpolator())
        .oneShot(layoutWinner, 70);
    }
}
