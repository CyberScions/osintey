package com.msmos.osintey;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import java.net.URISyntaxException;
import java.net.URLEncoder;

public class Start {
    public static void main(String[] args) {
        CommandParser.parseArguments(args);
        String searchQuery;

        if ( Global.facebook   ) openInFirefox(Global.facebookURL);
        if ( Global.twitter    ) openInFirefox(Global.twitterURL);
        if ( Global.linkedIn   ) openInFirefox(Global.linkedInURL);
        if ( Global.scribd     ) openInFirefox(Global.scribdURL);
        if ( Global.slideShare ) openInFirefox(Global.slideShareURL);

    }

    private static String createSearchString(String inURL) {
        String value = "inurl:" + inURL;
        for (String term : Global.searchParameters) {
            value = value + " " + term;
        }

        return value;
    }

    private static void openInFirefox(String inURL) {
        String searchQuery = createSearchString(inURL);
        String url;

        /*URL format the string.*/
        try {
/*            URIBuilder uri = new URIBuilder(Global.baseURL + searchQuery);
            url = uri.build().toString();*/

            url = Global.baseURL + URLEncoder.encode(searchQuery, "utf-8");

            //DEBUG
            System.out.println("loading: " + url);

            /*Load it up in Selenium*/
            WebDriver driver = new FirefoxDriver();
            driver.get(url);

        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(-1);
        }


    }
}
