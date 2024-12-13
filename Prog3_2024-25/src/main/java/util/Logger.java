package util;

import java.text.SimpleDateFormat;

public class Logger {

    private static final String RESET = "\u001b[0m";

    private static final String RED = "\u001b[31m";
    private static final String GREEN = "\u001b[32m";
    private static final String YELLOW = "\u001b[33m";
    private static final String BLUE = "\u001b[34m";
    private static final String MAGENTA = "\u001b[35m";
    private static final String CYAN = "\u001b[36m";
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");


    public static void log(String message) {
        log(message, LogLevel.Info);
    }



    public static void log(String message, LogLevel level) {
        String dateString = dateFormat.format(System.currentTimeMillis());
        String threadName = Thread.currentThread().getName();
        //[2024-01-01 10:30:16.678][threadname] Info: nase sporocilo
        
        String messagePrefix = "["+dateString+"]["+threadName+"] "+level+": ";
        switch (level) {
            case Info -> messagePrefix = YELLOW + messagePrefix + RESET;
            case Debug -> messagePrefix = BLUE + messagePrefix + RESET;
            case Warn -> messagePrefix = MAGENTA + messagePrefix + RESET;
            case Error -> messagePrefix = RED + messagePrefix + RESET;
            case Success -> messagePrefix = GREEN + messagePrefix + RESET;
            case Status -> messagePrefix = CYAN + messagePrefix + RESET;
        }

        System.out.println(messagePrefix+message);
        
        
    }

    public static void chat(String sender, String body){
        System.out.println(CYAN + "[" + sender + "] " + body);
    }

}
