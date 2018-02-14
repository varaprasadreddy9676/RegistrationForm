package com.example.msvreddy.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();

        ((TextView)findViewById(R.id.name_text)).setText(String.format("Name: \n%s", in.getStringExtra("username")));
        ((TextView)findViewById(R.id.college_name_text_view)).setText(String.format("College:\n%s", in.getStringExtra("college")));
        ((TextView)findViewById(R.id.phone_text_view)).setText(String.format("Phone:\n%s", in.getStringExtra("phone")));
        ((TextView)findViewById(R.id.email_text_view)).setText(String.format("Email:\n%s", in.getStringExtra("email")));
        ((TextView)findViewById(R.id.branch_text_view)).setText(String.format("Branch:\n%s", in.getStringExtra("branch")));
        ((TextView)findViewById(R.id.year_text_view)).setText(String.format("Year:\n%s", in.getStringExtra("year")));

        ((TextView)findViewById(R.id.gender_text_view)).setText(String.format("Gender\n%s", in.getStringExtra("gender_of_user")));

        String interests="";
        for (String interest : in.getStringArrayListExtra("interests_from_mainactivity")) {
            interests = interests + "\n" + interest;
        }
        ((TextView)findViewById(R.id.interests_text_view)).setText(String.format("Interests:%s", interests));

    }
}
