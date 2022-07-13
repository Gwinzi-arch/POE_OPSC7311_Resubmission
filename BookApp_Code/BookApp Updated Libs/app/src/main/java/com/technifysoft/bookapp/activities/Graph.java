package com.technifysoft.bookapp.activities;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.technifysoft.bookapp.R;
import com.technifysoft.bookapp.databinding.ActivityGraphBinding;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {


    ArrayList barArraylist;
    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    Query query = dbRef.child("categories").orderByChild("id");

    private ActivityGraphBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraphBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        BarChart barChart = findViewById(R.id.BarChart);

        getData();
        BarDataSet barDataSet = new BarDataSet(barArraylist, "Graph");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
    }

    private void getData()
    {
        barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(2f,1));
        barArraylist.add(new BarEntry(3f, 2));
        barArraylist.add(new BarEntry(4f , 3));
        barArraylist.add(new BarEntry(5f,4));
    }

    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            long count = ds.child("categories").getChildrenCount();

            Log.d("TAG", "Count:" + count);
        }
    }
}

