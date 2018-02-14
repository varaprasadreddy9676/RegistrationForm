package com.example.msvreddy.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String sYear;
    public String sBranch;
    public String gender_selected = "";

    public EditText username;
    public EditText college_name;
    public EditText phone_number;
    public EditText email_address;

    public Spinner branches_spinner;
    public Spinner year_spinner;

    public RadioGroup gender;

    public CheckBox[] checkBoxes = new CheckBox[5];

    public ArrayList<String> selected_interests = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.user_name);
        college_name = findViewById(R.id.college_name);
        phone_number = findViewById(R.id.phone_num);
        email_address = findViewById(R.id.email_add);

        branches_spinner = findViewById(R.id.branch_item);
        branches_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sBranch = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayAdapter<CharSequence> aaBranch = ArrayAdapter.createFromResource(
                this,
                R.array.list_of_branches,
                android.R.layout.simple_spinner_dropdown_item
        );

        aaBranch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branches_spinner.setAdapter(aaBranch);

        year_spinner = findViewById(R.id.year);
        year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sYear = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> aaYear = ArrayAdapter.createFromResource(
                this,
                R.array.year_list,
                android.R.layout.simple_spinner_dropdown_item
        );

        aaYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year_spinner.setAdapter(aaYear);


        (findViewById(R.id.submit_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gender_selected.equals("") ||
                        username.getText().toString().equals("") ||
                        college_name.getText().toString().equals("") ||
                        phone_number.getText().toString().equals("") ||
                        email_address.getText().toString().equals("")
                        ) {
                    Toast.makeText(MainActivity.this, "Fill up full form!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, detail.class);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("college", college_name.getText().toString());
                    intent.putExtra("phone", phone_number.getText().toString());
                    intent.putExtra("email", email_address.getText().toString());
                    intent.putExtra("year", sYear);
                    intent.putExtra("branch", sBranch);
                    intent.putExtra("gender_of_user", gender_selected);
                    intent.putStringArrayListExtra("interests_from_mainactivity", selected_interests);
                    startActivity(intent);
                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.user_male:
                if (checked)
                    gender_selected = "Male";
                break;
            case R.id.user_female:
                if (checked)
                    gender_selected = "Female";
                break;
        }
    }

    public void onCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.java:
                if (checked)
                    selected_interests.add("Java");
                else
                    selected_interests.remove("Java");
                break;
            case R.id.android:
                if (checked)
                    selected_interests.add("Android");
                else
                    selected_interests.remove("Android");
                break;
            case R.id.php:
                if (checked)
                    selected_interests.add("PHP");
                else
                    selected_interests.remove("PHP");
                break;
            case R.id.python:
                if (checked)
                    selected_interests.add("Python");
                else
                    selected_interests.remove("Python");
                break;
            case R.id.nodejs:
                if (checked)
                    selected_interests.add("Node Js");
                else
                    selected_interests.remove("Node Js");
                break;
        }
    }
}

