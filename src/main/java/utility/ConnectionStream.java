package main.java.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ConnectionStream {
    private static PrintWriter out = null;
    private static BufferedReader in = null;

    public static void send(String data) {
        out.println(data);
    }

    public static String receive() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setOut(PrintWriter outStream) {
        out = outStream;
    }

    public static void setIn(BufferedReader inStream) {
        in = inStream;
    }

    public static PrintWriter getOut(){
        return out;
    }

    public static BufferedReader getIn(){
        return in;
    }

    public static void setStream(PrintWriter outStream, BufferedReader inStream) {
        out = outStream;
        in = inStream;
    }

    public static void close() {
        try {
            out.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
