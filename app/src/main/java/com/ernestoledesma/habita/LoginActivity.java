package com.ernestoledesma.habita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ernestoledesma.habita.view.ContainerActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public  void  goHome(View view){

        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
