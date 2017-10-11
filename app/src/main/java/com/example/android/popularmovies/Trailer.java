package com.example.android.popularmovies;


public class Trailer {
    private String mTrailerKey;
    private String mTrailerName;

    public Trailer(String trailerKey, String trailerName) {
        mTrailerKey = trailerKey;
        mTrailerName = trailerName;
    }

    public String getTrailerKey() {
        return mTrailerKey;
    }

    public String getTrailerName() {
        return mTrailerName;
    }

}
