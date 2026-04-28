package com.app.toastlibrary;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastLib {

    public enum ToastType {
        SUCCESS,
        ERROR,
        INFO,
        NORMAL
    }

    public static void show(Context context, String message) {
        show(context, message, ToastType.NORMAL, Gravity.BOTTOM);
    }

    public static void success(Context context, String message) {
        show(context, message, ToastType.SUCCESS, Gravity.BOTTOM);
    }

    public static void error(Context context, String message) {
        show(context, message, ToastType.ERROR, Gravity.BOTTOM);
    }

    public static void info(Context context, String message) {
        show(context, message, ToastType.INFO, Gravity.BOTTOM);
    }

    public static void show(Context context,
                            String message,
                            ToastType type,
                            int gravity) {

        LayoutInflater inflater =
                LayoutInflater.from(context);

        View layout =
                inflater.inflate(
                        R.layout.toast_layout,
                        null
                );

        TextView text =
                layout.findViewById(R.id.toastText);

        ImageView icon =
                layout.findViewById(R.id.toastIcon);

        text.setText(message);

        switch (type) {

            case SUCCESS:
                layout.setBackgroundResource(
                        R.drawable.toast_success_bg);
                icon.setImageResource(
                        R.drawable.ic_success);
                break;

            case ERROR:
                layout.setBackgroundResource(
                        R.drawable.toast_error_bg);
                icon.setImageResource(
                        R.drawable.ic_error);
                break;

            case INFO:
                layout.setBackgroundResource(
                        R.drawable.toast_info_bg);
                icon.setImageResource(
                        R.drawable.ic_info);
                break;

            default:
                layout.setBackgroundResource(
                        R.drawable.toast_bg);
                icon.setImageResource(
                        R.drawable.ic_default);
        }

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 150);
        toast.setView(layout);
        toast.show();
    }
}