package com.test.acm.projectandroid;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by Jason on 5/4/2016.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        TextView tv1 = (TextView) getActivity().findViewById(R.id.timePickText);
        String timeQualifier = "AM";

        if (hourOfDay >= 12) {
            hourOfDay -= 12;
            timeQualifier = "PM";
        }
        if (hourOfDay == 0) {
            hourOfDay = 12;
        }
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("User hour:", hourOfDay);
        editor.putInt("User minute:",minute);
        editor.commit();
        DecimalFormat formatter = new DecimalFormat("00");
        String s = formatter.format(minute);
        tv1.setText("You have entered: \n" + hourOfDay + ":" + s + timeQualifier);
    }


}
