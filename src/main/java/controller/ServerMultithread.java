package main.java.controller;

import main.java.utility.ConnectionStream;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ServerMultithread extends Thread{
    private final Socket clientSocket;
    public ServerMultithread(Socket socket) {
        this.clientSocket = socket;
    }// end of constructor

    public void run(){

            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ConnectionStream.setStream(out,in);

                System.out.println("streams created");
                Router.route();

            }
            catch (SocketException e){
                System.err.println("Socket Closed");
            }
            catch (Exception e){
                System.err.println("exception in input streams");
            }
            finally {
                ConnectionStream.close();
            }

    }// end of run
}
