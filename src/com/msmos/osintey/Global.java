package com.msmos.osintey;

public class Global {
    /*Command line args*/
    public static boolean linkedIn = false;
    static final String linkedInFlag = "L";
    static final String linkedInLongFlag = "linkedin";

    public static boolean scribd = false;
    static final String scribdFlag = "S";
    static final String scribdLongFlag = "scribd";

    public static boolean facebook = false;
    static final String facebookFlag = "F";
    static final String facebookLongFlag = "facebook";

    public static boolean slideShare = false;
    static final String slideShareFlag = "SS";
    static final String slideShareLongFlag = "slideshare";

    public static boolean twitter = false;
    static final String twitterFlag = "T";
    static final String twitterLongFlag = "twitter";

    public static String[] searchParameters;
    static final String paramFlag = "p";
    static final String paramLongFlag = "parameters";

    /*Searchable URLS*/
    static final String linkedInURL = "linkedin.com";
    static final String scribdURL = "scribd.com";
    static final String facebookURL = "facebook.com";
    static final String slideShareURL = "slideshare.net";
    static final String twitterURL = "twitter.com";

    /*Other globals*/
    static final String baseURL = "http://encrypted.google.com/search?q=";
}
