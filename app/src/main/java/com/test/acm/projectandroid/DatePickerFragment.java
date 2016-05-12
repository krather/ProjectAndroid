package com.test.acm.projectandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by TheBit on 5/11/2016.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        //The way Android handles dates is as follows:
        //@year - Start count from 0 (2016 is the 2016th year);
        //@month - Start count from 0 (i.e. January is the 0th month);
        //@day - Start count from 1 (The 13th day of the month is the 13th day);

        TextView tv1 = (TextView) getActivity().findViewById(R.id.datePickText);
        String stringMonth = getMonth(month);
        tv1.setText("You have entered: \n" + stringMonth + " " + day + ", " + year);
    }

    public String getMonth(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October","November","December"};
        return (months[month]);
    }
}