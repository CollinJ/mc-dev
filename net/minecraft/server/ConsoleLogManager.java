package net.minecraft.server;

import java.util.logging.*;

public class ConsoleLogManager {

    public static Logger a = Logger.getLogger("Minecraft");

    public ConsoleLogManager() {}

    public static void a() {
        ConsoleLogFormatter consolelogformatter = new ConsoleLogFormatter();

        a.setUseParentHandlers(false);
        ConsoleHandler consolehandler = new ConsoleHandler();

        ((Handler) (consolehandler)).setFormatter(((java.util.logging.Formatter) (consolelogformatter)));
        a.addHandler(((Handler) (consolehandler)));
        try {
            FileHandler filehandler = new FileHandler("server.log", true);

            ((Handler) (filehandler)).setFormatter(((java.util.logging.Formatter) (consolelogformatter)));
            a.addHandler(((Handler) (filehandler)));
        } catch (Exception exception) {
            a.log(Level.WARNING, "Failed to log to server.log", ((Throwable) (exception)));
        }
    }
}
