package com.rokan.humaclab.studentprofile;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Humac Lab on 12/20/2015.
 */
public class DateTimeParser {

    public static Date getDateFromString(String dateString, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date formattedDate = null;

        try {
            formattedDate = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            Log.d("DateParseException", "Date time exception");
        }

        return formattedDate;
    }

    public static String getStringFromDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String formattedString = simpleDateFormat.format(date);

        return formattedString;
    }

}
