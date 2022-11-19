package main.java.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerSideSocket {

    public void startConnection() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 6789.");
        }

        Socket clientSocket = null;
        try {
            System.out.println("waiting for client connection");
            while (true) {
                new ServerMultithread(serverSocket.accept()).start();
                System.out.println("Connected to a client");
            }
        } catch (IOException e) {
            System.err.println("Accept failed.");
        }

    }// end of startConnection()

}
