package com.example.countdowntimer;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import com.google.android.material.button.MaterialButton;

public class TimerInitializationManager {
    public interface OnTimeSetListener { // Interface for a callback when the time is set
        void onTimeSet(long timeInMillis);
    }

    private Context context;
    private OnTimeSetListener listener; // Listener to notify when the time is set

    public TimerInitializationManager(Context context, OnTimeSetListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void showTimePickerDialog() {
        View dialogView = LayoutInflater.from(context).inflate(R.layout.activity_timer, null);

        NumberPicker timer_ITEM_hours = dialogView.findViewById(R.id.timer_ITEM_hours);
        NumberPicker timer_ITEM_minutes = dialogView.findViewById(R.id.timer_ITEM_minutes);
        NumberPicker timer_ITEM_seconds = dialogView.findViewById(R.id.timer_ITEM_seconds);
        MaterialButton timer_BTN_ok = dialogView.findViewById(R.id.timer_BTN_ok);
        MaterialButton timer_BTN_cancel = dialogView.findViewById(R.id.timer_BTN_cancel);

        // Set the range for each NumberPicker
        timer_ITEM_hours.setMinValue(0);
        timer_ITEM_hours.setMaxValue(23);
        timer_ITEM_minutes.setMinValue(0);
        timer_ITEM_minutes.setMaxValue(59);
        timer_ITEM_seconds.setMinValue(0);
        timer_ITEM_seconds.setMaxValue(59);

        AlertDialog alertDialog = new AlertDialog.Builder(context) // Create an AlertDialog to hold the custom view
                .setView(dialogView)
                .create();

        timer_BTN_ok.setOnClickListener(v -> {
            int hours = timer_ITEM_hours.getValue();
            int minutes = timer_ITEM_minutes.getValue();
            int seconds = timer_ITEM_seconds.getValue();
            long timeInMillis = (hours * 3600000L) + (minutes * 60000L) + (seconds * 1000L); // Convert the selected time to milliseconds
            listener.onTimeSet(timeInMillis); // Notify the listener with the selected time
            alertDialog.dismiss();
        });

        timer_BTN_cancel.setOnClickListener(v -> alertDialog.dismiss());

        alertDialog.show();
    }
}
