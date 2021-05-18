package com.example.soldevelointerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soldevelointerview.databinding.ActivitySummaryBinding;

public class SummaryActivity extends AppCompatActivity {

    private ActivitySummaryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySummaryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Intent intent = getIntent();
        String first_name = intent.getStringExtra(getString(R.string.first_name));
        String last_name = intent.getStringExtra(getString(R.string.last_name));
        String age_number = intent.getStringExtra(getString(R.string.age));
        boolean isChecked = this.getIntent().getBooleanExtra(getString(R.string.checkbox_result), false);


        String result = isChecked ? getString(R.string.yes) : getString(R.string.no);

        TextView mResultTv = binding.firstName;
        TextView last_nameTv = binding.lastName;
        TextView age_Tv = binding.age;
        TextView checkbox_Tv = binding.isExperienced;

        mResultTv.setText(String.format("%s%s", getString(R.string.first_name), first_name));
        last_nameTv.setText(String.format("%s%s", getString(R.string.last_name), last_name));
        age_Tv.setText(String.format("%s%s", getString(R.string.age), age_number));
        checkbox_Tv.setText(String.format("%s%s", getString(R.string.checkbox_result), result));
    }
}
