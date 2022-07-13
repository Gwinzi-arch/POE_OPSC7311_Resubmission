package com.technifysoft.bookapp;

import android.content.Intent;
import android.os.Bundle;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.technifysoft.bookapp.databinding.ActivityGamificationBinding;

public class Gamification extends AppCompatActivity {

    private ScratchView scratchView;
    private Button maskBtn;

    private ActivityGamificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGamificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        scratchView = findViewById(R.id.scratch_view);
        maskBtn = findViewById(R.id.mask_btn);

        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(Gamification.this, "Revealed", Toast.LENGTH_SHORT).show();
                maskBtn.setVisibility(View.VISIBLE);


            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {

                maskBtn.setVisibility(View.GONE);
            }
        });

    }
    }
