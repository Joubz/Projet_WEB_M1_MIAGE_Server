package businessLogic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * main.Log class, put exception or string message in txt log file.
 */
public class Log {

    /**
     * write exception message on the log file
     *
     * @param exceptionMessage: exceptionMessage that will be written on the log file
     */
    public static void WriteMessage(Exception exceptionMessage) {
        try {
            File logFile = new File("/log/log.txt");
            if (!logFile.exists()) {
                createLogFile();
            }
            writeMessage(exceptionMessage.getMessage());

        } catch (Exception e) {
            System.out.println("An error has occurred:");
            e.printStackTrace();
        }
    }

    /**
     * write string message on the log file
     *
     * @param stringMessage: string message that will be written on the log file
     */
    public static void WriteMessage(String stringMessage) {
        try {
            File logFile = new File("/log/log.txt");
            if (!logFile.exists()) {
                createLogFile();
            }
            writeMessage(stringMessage);
        } catch (Exception e) {
            System.out.println("An error has occurred:");
            e.printStackTrace();
        }
    }

    /**
     * @param message: Message that will be written on log file
     */
    private static void writeMessage(String message) {
        try {
            FileWriter writerLogFile = new FileWriter("/log/log.txt");
            writerLogFile.write(message);
            writerLogFile.close();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu.");
            e.printStackTrace();
        }
    }


    /**
     * Create log file
     */
    private static void createLogFile() {
        try {
            File logFile = new File("/log/log.txt");
        } catch (Exception e) {
            System.out.println("Une erreur est survenu.");
            e.printStackTrace();
        }
    }
}
