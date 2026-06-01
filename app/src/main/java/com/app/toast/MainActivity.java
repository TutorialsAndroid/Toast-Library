package com.app.toast;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.toastlibrary.ToastLib;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton btnSuccess;
    private MaterialButton btnError;
    private MaterialButton btnInfo;
    private MaterialButton btnWarning;
    private MaterialButton btnDefault;
    private MaterialButton btnLong;
    private MaterialButton btnTop;
    private MaterialButton btnCenter;
    private MaterialButton btnBuilder;
    private MaterialButton btnCustom;
    private MaterialButton btnNoIcon;

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
        btnWarning = findViewById(R.id.btn_warning);
        btnDefault = findViewById(R.id.btn_default);
        btnLong = findViewById(R.id.btn_long);
        btnTop = findViewById(R.id.btn_top);
        btnCenter = findViewById(R.id.btn_center);
        btnBuilder = findViewById(R.id.btn_builder);
        btnCustom = findViewById(R.id.btn_custom);
        btnNoIcon = findViewById(R.id.btn_no_icon);

        btnSuccess.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnWarning.setOnClickListener(this);
        btnDefault.setOnClickListener(this);
        btnLong.setOnClickListener(this);
        btnTop.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnBuilder.setOnClickListener(this);
        btnCustom.setOnClickListener(this);
        btnNoIcon.setOnClickListener(this);
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

        if (view == btnWarning) {
            ToastLib.warning(this, "Please check this action");
        }

        if (view == btnDefault) {
            ToastLib.show(this, "Default toast");
        }

        if (view == btnLong) {
            ToastLib.longToast(this, "This toast stays longer");
        }

        if (view == btnTop) {
            ToastLib.top(this, "Top toast notification", ToastLib.ToastType.INFO);
        }

        if (view == btnCenter) {
            ToastLib.center(this, "Centered alert style toast", ToastLib.ToastType.WARNING);
        }

        if (view == btnBuilder) {
            ToastLib.builder(this)
                    .message("Builder API toast with custom options")
                    .type(ToastLib.ToastType.SUCCESS)
                    .gravity(Gravity.BOTTOM)
                    .longDuration()
                    .cornerRadiusDp(24)
                    .paddingDp(18, 14)
                    .maxLines(2)
                    .show();
        }

        if (view == btnCustom) {
            ToastLib.builder(this)
                    .message("Custom brand toast")
                    .icon(R.drawable.ic_launcher_foreground)
                    .backgroundColor(Color.parseColor("#7C3AED"))
                    .textColor(Color.WHITE)
                    .iconTint(Color.WHITE)
                    .textStyle(Typeface.BOLD)
                    .show();
        }

        if (view == btnNoIcon) {
            ToastLib.builder(this)
                    .message("Clean toast without icon")
                    .type(ToastLib.ToastType.NORMAL)
                    .hideIcon()
                    .backgroundColor(Color.parseColor("#0F172A"))
                    .show();
        }
    }
}
