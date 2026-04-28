package com.app.toast;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.toastlibrary.ToastLib;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton btnSuccess, btnError, btnInfo, btnDefault;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {
        btnSuccess = findViewById(R.id.btn_success);
        btnError = findViewById(R.id.btn_error);
        btnInfo = findViewById(R.id.btn_info);
        btnDefault = findViewById(R.id.btn_default);

        btnSuccess.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnDefault.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSuccess) {
            ToastLib.success(this, "Saved successfully");
        }

        if (view == btnError) {
            ToastLib.error(this, "Something went wrong");
        }

        if (view == btnInfo) {
            ToastLib.info(this, "Welcome back!");
        }

        if (view == btnDefault) {
            ToastLib.show(this, "Default toast");
        }
    }
}
