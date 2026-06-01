package com.app.toastlibrary;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ToastLib v3.0.0
 *
 * Lightweight custom toast library for Android.
 * - Backward compatible with v2.0.0 static API
 * - New builder API
 * - Warning toast
 * - Custom icon/background/text color
 * - Custom duration/gravity/offset
 * - One-toast-at-a-time queue behavior
 * - Safer application-context usage
 */
public final class ToastLib {

    private ToastLib() {
        // Utility class
    }

    public enum ToastType {
        SUCCESS,
        ERROR,
        INFO,
        WARNING,
        NORMAL
    }

    private static final int DEFAULT_Y_OFFSET_DP = 96;
    private static final int DEFAULT_CORNER_RADIUS_DP = 18;
    private static final int DEFAULT_HORIZONTAL_PADDING_DP = 16;
    private static final int DEFAULT_VERTICAL_PADDING_DP = 12;
    private static final float DEFAULT_TEXT_SIZE_SP = 15f;
    private static final int DEFAULT_MAX_LINES = 3;

    private static Toast currentToast;

    /*
     * -------------------------------------------------------------------------
     * Backward-compatible v2.0.0 API
     * -------------------------------------------------------------------------
     */

    public static void show(Context context, String message) {
        show(context, message, ToastType.NORMAL, Gravity.BOTTOM);
    }

    public static void normal(Context context, String message) {
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

    public static void warning(Context context, String message) {
        show(context, message, ToastType.WARNING, Gravity.BOTTOM);
    }

    public static void show(Context context,
                            String message,
                            ToastType type,
                            int gravity) {
        builder(context)
                .message(message)
                .type(type)
                .gravity(gravity)
                .show();
    }

    /*
     * -------------------------------------------------------------------------
     * Convenience APIs
     * -------------------------------------------------------------------------
     */

    public static void longToast(Context context, String message) {
        builder(context)
                .message(message)
                .duration(Toast.LENGTH_LONG)
                .show();
    }

    public static void top(Context context, String message, ToastType type) {
        builder(context)
                .message(message)
                .type(type)
                .gravity(Gravity.TOP)
                .offset(0, dp(context, 72))
                .show();
    }

    public static void center(Context context, String message, ToastType type) {
        builder(context)
                .message(message)
                .type(type)
                .gravity(Gravity.CENTER)
                .offset(0, 0)
                .show();
    }

    public static void custom(Context context,
                              String message,
                              int iconResId,
                              int backgroundColor,
                              int textColor) {
        builder(context)
                .message(message)
                .icon(iconResId)
                .backgroundColor(backgroundColor)
                .textColor(textColor)
                .show();
    }

    public static void cancelCurrent() {
        if (currentToast != null) {
            currentToast.cancel();
            currentToast = null;
        }
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    /*
     * -------------------------------------------------------------------------
     * Builder API
     * -------------------------------------------------------------------------
     */

    public static final class Builder {

        private final Context context;

        private String message = "";
        private ToastType type = ToastType.NORMAL;
        private int gravity = Gravity.BOTTOM;
        private int duration = Toast.LENGTH_SHORT;
        private int xOffset = 0;
        private int yOffset;
        private int iconResId = 0;
        private boolean hideIcon = false;
        private boolean tintIcon = true;
        private int iconTintColor = Color.WHITE;
        private int backgroundColor = Integer.MIN_VALUE;
        private int textColor = Color.WHITE;
        private float textSizeSp = DEFAULT_TEXT_SIZE_SP;
        private int textStyle = Typeface.BOLD;
        private int cornerRadiusPx;
        private int horizontalPaddingPx;
        private int verticalPaddingPx;
        private int maxLines = DEFAULT_MAX_LINES;
        private boolean cancelPrevious = true;

        private Builder(Context context) {
            this.context = context == null ? null : context.getApplicationContext();

            if (context != null) {
                this.yOffset = dp(context, DEFAULT_Y_OFFSET_DP);
                this.cornerRadiusPx = dp(context, DEFAULT_CORNER_RADIUS_DP);
                this.horizontalPaddingPx = dp(context, DEFAULT_HORIZONTAL_PADDING_DP);
                this.verticalPaddingPx = dp(context, DEFAULT_VERTICAL_PADDING_DP);
            }
        }

        public Builder message(String message) {
            this.message = message == null ? "" : message.trim();
            return this;
        }

        public Builder type(ToastType type) {
            this.type = type == null ? ToastType.NORMAL : type;
            return this;
        }

        public Builder gravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration == Toast.LENGTH_LONG
                    ? Toast.LENGTH_LONG
                    : Toast.LENGTH_SHORT;
            return this;
        }

        public Builder shortDuration() {
            this.duration = Toast.LENGTH_SHORT;
            return this;
        }

        public Builder longDuration() {
            this.duration = Toast.LENGTH_LONG;
            return this;
        }

        public Builder offset(int xOffset, int yOffset) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            return this;
        }

        public Builder yOffsetDp(int yOffsetDp) {
            if (context != null) {
                this.yOffset = dp(context, yOffsetDp);
            }
            return this;
        }

        public Builder icon(int iconResId) {
            this.iconResId = iconResId;
            this.hideIcon = false;
            return this;
        }

        public Builder hideIcon() {
            this.hideIcon = true;
            return this;
        }

        public Builder iconTint(int iconTintColor) {
            this.tintIcon = true;
            this.iconTintColor = iconTintColor;
            return this;
        }

        public Builder disableIconTint() {
            this.tintIcon = false;
            return this;
        }

        public Builder backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder textSize(float textSizeSp) {
            if (textSizeSp > 0) {
                this.textSizeSp = textSizeSp;
            }
            return this;
        }

        public Builder textStyle(int textStyle) {
            this.textStyle = textStyle;
            return this;
        }

        public Builder cornerRadiusDp(int radiusDp) {
            if (context != null && radiusDp >= 0) {
                this.cornerRadiusPx = dp(context, radiusDp);
            }
            return this;
        }

        public Builder paddingDp(int horizontalDp, int verticalDp) {
            if (context != null) {
                this.horizontalPaddingPx = dp(context, Math.max(0, horizontalDp));
                this.verticalPaddingPx = dp(context, Math.max(0, verticalDp));
            }
            return this;
        }

        public Builder maxLines(int maxLines) {
            this.maxLines = Math.max(1, maxLines);
            return this;
        }

        public Builder cancelPrevious(boolean cancelPrevious) {
            this.cancelPrevious = cancelPrevious;
            return this;
        }

        @SuppressWarnings("deprecation")
        public void show() {
            if (context == null || TextUtils.isEmpty(message)) {
                return;
            }

            View layout = LayoutInflater.from(context)
                    .inflate(R.layout.toast_layout, null, false);

            View container = layout.findViewById(R.id.toastContainer);
            TextView text = layout.findViewById(R.id.toastText);
            ImageView icon = layout.findViewById(R.id.toastIcon);

            int finalBackgroundColor = backgroundColor == Integer.MIN_VALUE
                    ? getDefaultBackgroundColor(context, type)
                    : backgroundColor;

            GradientDrawable background = new GradientDrawable();
            background.setShape(GradientDrawable.RECTANGLE);
            background.setColor(finalBackgroundColor);
            background.setCornerRadius(cornerRadiusPx);
            container.setBackground(background);
            container.setPadding(
                    horizontalPaddingPx,
                    verticalPaddingPx,
                    horizontalPaddingPx,
                    verticalPaddingPx
            );

            if (container.getElevation() < dp(context, 6)) {
                container.setElevation(dp(context, 6));
            }

            text.setText(message);
            text.setTextColor(textColor);
            text.setTextSize(textSizeSp);
            text.setTypeface(Typeface.DEFAULT, textStyle);
            text.setMaxLines(maxLines);
            text.setEllipsize(TextUtils.TruncateAt.END);

            if (hideIcon) {
                icon.setVisibility(View.GONE);
            } else {
                icon.setVisibility(View.VISIBLE);

                int resolvedIcon = iconResId != 0
                        ? iconResId
                        : getDefaultIcon(type);

                icon.setImageResource(resolvedIcon);

                if (tintIcon) {
                    icon.setColorFilter(iconTintColor);
                } else {
                    icon.clearColorFilter();
                }
            }

            Toast toast = new Toast(context);
            toast.setDuration(duration);
            toast.setGravity(gravity, xOffset, yOffset);
            toast.setView(layout);

            if (cancelPrevious) {
                cancelCurrent();
            }

            currentToast = toast;
            toast.show();
        }
    }

    private static int getDefaultIcon(ToastType type) {
        switch (type) {
            case SUCCESS:
                return R.drawable.ic_success;

            case ERROR:
                return R.drawable.ic_error;

            case INFO:
                return R.drawable.ic_info;

            case WARNING:
                return R.drawable.ic_warning;

            case NORMAL:
            default:
                return R.drawable.ic_default;
        }
    }

    private static int getDefaultBackgroundColor(Context context, ToastType type) {
        switch (type) {
            case SUCCESS:
                return Color.parseColor("#16A34A");

            case ERROR:
                return Color.parseColor("#DC2626");

            case INFO:
                return Color.parseColor("#2563EB");

            case WARNING:
                return Color.parseColor("#F59E0B");

            case NORMAL:
            default:
                boolean nightMode = (context.getResources().getConfiguration().uiMode
                        & Configuration.UI_MODE_NIGHT_MASK)
                        == Configuration.UI_MODE_NIGHT_YES;

                return nightMode
                        ? Color.parseColor("#020617")
                        : Color.parseColor("#111827");
        }
    }

    private static int dp(Context context, float value) {
        if (context == null) {
            return (int) value;
        }

        return (int) (value * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
