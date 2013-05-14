package com.msmos.osintey;

import org.apache.commons.cli.*;

public class CommandParser {
    public static void parseArguments (String[] args) {
        /*Add the options to the parser*/
        Options options = new Options();
        options.addOption(Global.facebookFlag, Global.facebookLongFlag, false, "Loads a Facebook window.");
        options.addOption(Global.twitterFlag, Global.twitterLongFlag, false, "Loads a Twitter window.");
        options.addOption(Global.linkedInFlag, Global.linkedInLongFlag, false, "Loads a LinkedIn window.");
        options.addOption(Global.scribdFlag, Global.scribdLongFlag, false, "Loads a Scribd window.");
        options.addOption(Global.slideShareFlag, Global.slideShareLongFlag, false, "Loads a SlideShare window.");
        options.addOption(Global.paramFlag, Global.paramLongFlag, true, "Search terms to query Google with.");

        /*Attempt to parse the command line arguments*/
        CommandLineParser parser = new BasicParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);

            /*Transfer the data from the command line arguments into the Global class*/
            // Do we have our required variables.
            if ( !cmd.hasOption(Global.paramFlag) ) {
                throw new Exception("Parameter flag must have values.");
            } else {
                Global.searchParameters = cmd.getOptionValues(Global.paramFlag);
            }

            if ( cmd.hasOption(Global.facebookFlag)   ) Global.facebook = true;
            if ( cmd.hasOption(Global.linkedInFlag)   ) Global.linkedIn = true;
            if ( cmd.hasOption(Global.twitterFlag)    ) Global.twitter = true;
            if ( cmd.hasOption(Global.scribdFlag)     ) Global.scribd = true;
            if ( cmd.hasOption(Global.slideShareFlag) ) Global.slideShare = true;

        } catch (Exception e) {
            System.err.println(e.toString());
            HelpFormatter help = new HelpFormatter();
            help.printHelp("osintey", options);
            System.exit(-1);
        }



    }

}
