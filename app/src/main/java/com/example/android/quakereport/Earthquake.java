package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.io.File.separator;

/**
 * Created by juan on 23/08/17.
 */

public class Earthquake {
    /** earthquake's magnitude **/
    private double mMagnitude;

    /** earthquake's location **/
    private String mLocation;
    private String mPlace;
    private String mOffset;

    /** earthquake's date and time **/
    private Date mTime;

    /** 'more info' URL **/
    private String mUrl;

    /** readable date format **/
    private final String DATE_FORMAT = "MMM dd, yyyy";

    /** readable time format **/
    private final String TIME_FORMAT = "HH:mm aa";

    /** location separator **/
    private final String SEPARATOR_REGEX = "(?<=(\\sof\\s))";

    /**
     * Construct.
     * @param magnitude
     * @param location
     * @param time
     */
    public Earthquake(double magnitude, String location, Date time, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTime = time;
        this.mUrl = url;

        String[] locationData = location.split(SEPARATOR_REGEX, 2);
        if (locationData.length > 1) {
            mPlace = locationData[1];
            mOffset = locationData[0];
        } else {
            mPlace = locationData[0];
            mOffset = null;
        }
    }

    /**
     * @return earthquake's magnitude.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return earthquake's location.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return earthquake's date and time.
     */
    public Date getTime() {
        return mTime;
    }

    /**
     * @return earthquake's readable date.
     */
    public String getReadableDate() {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT, Locale.US);

        //Convert Date to String
        String dateString = df.format(getTime());

        return dateString;
    }

    public String getReadableTime() {
        SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT, Locale.US);

        //Convert Date to String
        String timeString = df.format(getTime());

        return timeString;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getOffset() {
        return mOffset;
    }

    public String getUrl() {
        return mUrl;
    }
}
