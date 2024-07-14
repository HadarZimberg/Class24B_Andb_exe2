package com.example.class24b_andb_exe2;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatToggleButton;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Locale;

public class TimerManager {
    protected MaterialTextView main_TXT_chronometer;
    protected AppCompatToggleButton main_BTN_toggle;
    protected MaterialButton main_BTN_stop;
    protected Context context;
    private Handler handler = new Handler();
    private long timeInMillis;
    private long timeLeftInMillis;
    private boolean isRunning;
    private Runnable timerRunnable;
    private long endTime;
    private MediaPlayer mediaPlayer;

    public TimerManager(Context context, MaterialTextView main_TXT_chronometer, AppCompatToggleButton main_BTN_toggle, MaterialButton main_BTN_stop) {
        this.context = context;
        this.main_TXT_chronometer = main_TXT_chronometer;
        this.main_BTN_toggle = main_BTN_toggle;
        this.main_BTN_stop = main_BTN_stop;
        mediaPlayer = MediaPlayer.create(context, R.raw.finish);
    }

    public void setTimeInMillis(long timeInMillis) { // Set the initial time in milliseconds
        this.timeInMillis = timeInMillis;
        this.timeLeftInMillis = timeInMillis;
    }

    public void onToggleButtonClicked() {
        if (isRunning) {
            pauseTimer();
            main_BTN_toggle.setBackgroundResource(R.drawable.start);
        }
        else {
            startTimer();
            main_BTN_toggle.setBackgroundResource(R.drawable.pause);
        }
    }

    public void onStopButtonClicked() {
        pauseTimer();
        resetTimer();
        main_BTN_toggle.setBackgroundResource(R.drawable.start);
    }

    private void startTimer() {
        endTime = System.currentTimeMillis() + timeLeftInMillis;
        isRunning = true;
        handler.post(timerRunnable = new Runnable() { // Update the timer
            @Override
            public void run() {
                timeLeftInMillis = endTime - System.currentTimeMillis();
                if (timeLeftInMillis > 0) {
                    updateChronometer(timeLeftInMillis);
                    handler.postDelayed(this, 10);
                }
                else {
                    Toast.makeText(context, "Timer finished!", Toast.LENGTH_SHORT).show();
                    playFinishSound();
                    timeLeftInMillis = 0;
                    isRunning = false;
                    updateChronometer(timeLeftInMillis);
                    main_BTN_toggle.setBackgroundResource(R.drawable.start);
                }
            }
        });
    }

    private void pauseTimer() {
        if (isRunning) {
            handler.removeCallbacks(timerRunnable);
            timeLeftInMillis = endTime - System.currentTimeMillis();
            isRunning = false;
        }
    }

    private void resetTimer() {
        timeLeftInMillis = timeInMillis;
        updateChronometer(timeLeftInMillis);
    }

    private void playFinishSound() {
        if (mediaPlayer != null)
            mediaPlayer.start();
    }

    public void updateChronometer(long timeInMillis) { // Update the chronometer display
        int minutes = (int) (timeInMillis / 60000);
        int seconds = (int) (timeInMillis % 60000) / 1000;
        int milliseconds = (int) ((timeInMillis % 1000) / 10);
        main_TXT_chronometer.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", minutes, seconds, milliseconds));
    }

    @Override
    protected void finalize() throws Throwable {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.finalize();
    }
}
