package com.example.soldevelointerview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.soldevelointerview.databinding.ActivityFormBinding;


public class FormActivity extends AppCompatActivity {

    private ActivityFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        final TextView firstName = binding.firstNameEt;
        final TextView lastName = binding.lastNameEt;
        final TextView ageNumber = binding.ageEt;
        final CheckBox experienced = binding.checkBox;

        clearText();

        Button accept_btn = binding.acceptBt;

        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = firstName.getText().toString();
                String last_name = lastName.getText().toString();
                String age = ageNumber.getText().toString();
                boolean isChecked = experienced.isChecked();


                Intent intent = new Intent(FormActivity.this, SummaryActivity.class);
                intent.putExtra(getString(R.string.first_name) ,first_name);
                intent.putExtra(getString(R.string.last_name), last_name);
                intent.putExtra(getString(R.string.age), age);
                intent.putExtra(getString(R.string.checkbox_result), isChecked);

                startActivity(intent);
            }
        });
    }

    public void clearText() {
        Button clear_button = findViewById(R.id.button_clear);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView firstName = binding.firstNameEt;
                firstName.setText("");
                TextView lastName = binding.lastNameEt;
                lastName.setText("");
                TextView age = binding.ageEt;
                age.setText("");
                CheckBox experienced = binding.checkBox;
                experienced.setChecked(false);
            }
        });
    }
}