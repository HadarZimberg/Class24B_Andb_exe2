
# Count Down Timer Initialization Library

The Count Down Timer Initialization Library is an Android library designed to provide a customizable timer setup dialog that can be integrated with any timer application. The library includes a TimerInitializationManager for setting up the timer.

## Features
- Customizable Timer Initialization: Allows users to set hours, minutes, and seconds.
- Accurate Timer Management: Handles the timer countdown with accurate time updates.


## Add the Module to Your Project
If you haven't already, include the countDownTimer module in your project's dependencies. Open your app's build.gradle file and add:

```
dependencies {
    implementation project(':countDownTimer')
}
```

## Integration

1. Design the Layout
   Ensure your activity layout includes the required UI components.

2. Initialize the Timer in Your Activity
   Use the TimerInitializationManager for setting the timer duration and some timer manager for managing the timer's functionality.

3. Customize the Timer Initialization Dialog

Customize the TimerInitializationManager dialog by modifying activity_timer.xml. This layout includes NumberPicker elements for hours, minutes, and seconds, and buttons for OK and Cancel actions.

## Usage

- Open Timer Initialization Dialog:
  Clicking on the chronometer (main_TXT_chronometer) opens the timer initialization dialog.

- Set Timer Duration:
  In the dialog, use the NumberPicker elements to set the desired hours, minutes, and seconds. Clicking the OK button confirms the time, and the timer starts counting down from the set duration.

## Customization
You can customize the behavior and appearance of the timer and dialog as needed. Modify the layout files and update the TimerInitializationManager classes to fit your requirements.

## Example
Here's a step-by-step example of how to use the timer:

- Open the app.
- Click on the chronometer to open the timer initialization dialog.
- Set the desired duration using the NumberPicker elements and click OK.
- Click the toggle button to start the timer.
- Click the toggle button again to pause the timer.
- Click the stop button to stop and reset the timer.

![1Screenshot_20240714-173525_Class24B-Andb-exe2.jpg](screenshots%2F1Screenshot_20240714-173525_Class24B-Andb-exe2.jpg)

![2Screenshot_20240714-173535_Class24B-Andb-exe2.jpg](screenshots%2F2Screenshot_20240714-173535_Class24B-Andb-exe2.jpg)

![3Screenshot_20240714-173625_Class24B-Andb-exe2.jpg](screenshots%2F3Screenshot_20240714-173625_Class24B-Andb-exe2.jpg)

![4Screenshot_20240714-173634_Class24B-Andb-exe2.jpg](screenshots%2F4Screenshot_20240714-173634_Class24B-Andb-exe2.jpg)