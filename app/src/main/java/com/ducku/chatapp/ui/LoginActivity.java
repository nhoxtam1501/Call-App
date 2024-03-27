package com.ducku.chatapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ducku.chatapp.databinding.ActivityLoginBinding;
import com.ducku.chatapp.repository.MainRepository;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding views;
    private MainRepository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        views = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());

        init();
    }

    private void init() {
        repository = MainRepository.getInstance();

        views.enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login to firebase
                repository.login(views.username.getText().toString(), () -> {
                    startActivity(new Intent(LoginActivity.this, CallActivity.class));
                });
            }
        });
    }
}
