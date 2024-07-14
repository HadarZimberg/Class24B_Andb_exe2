package com.example.class24b_andb_exe2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import com.example.countdowntimer.TimerInitializationManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    protected MaterialTextView main_TXT_chronometer;
    protected AppCompatToggleButton main_BTN_toggle;
    protected MaterialButton main_BTN_stop;
    protected TimerManager timerManager;
    protected TimerInitializationManager timerInitializationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        main_TXT_chronometer.setText("00:00:00");
        timerManager = new TimerManager(this, main_TXT_chronometer, main_BTN_toggle, main_BTN_stop);
        timerInitializationManager = new TimerInitializationManager(this, timeInMillis -> { // Initialize TimerInitializationManager with a callback to set the time
            timerManager.setTimeInMillis(timeInMillis);
            timerManager.updateChronometer(timeInMillis);
        });

        initViews();

        Toast toast = Toast.makeText(this, "Tap the chronometer to set the time", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
        toast.show();
    }

    private void initViews() {
        main_TXT_chronometer.setOnClickListener(v -> openDialog());
        main_BTN_toggle.setOnClickListener(v -> timerManager.onToggleButtonClicked());
        main_BTN_stop.setOnClickListener(v -> timerManager.onStopButtonClicked());
    }

    private void openDialog() {
        timerInitializationManager.showTimePickerDialog(); // Open the time initialization dialog
    }

    private void findViews() {
        main_TXT_chronometer = findViewById(R.id.main_TXT_chronometer);
        main_BTN_toggle = findViewById(R.id.main_BTN_toggle);
        main_BTN_stop = findViewById(R.id.main_BTN_stop);
    }
}