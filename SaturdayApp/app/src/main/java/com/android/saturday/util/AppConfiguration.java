package com.android.saturday.util;

/**
 * Created by bhavdip on 9/3/16.
 */
public class AppConfiguration {

    private final static String APP_LOG = "GettyImages";
    private final static String BASE_URL = "https://api.gettyimages.com";

    private AppConfiguration() {
    }

    public static String logTag() {
        return APP_LOG;
    }

    public static String getBaseHost() {
        return BASE_URL;
    }
}
