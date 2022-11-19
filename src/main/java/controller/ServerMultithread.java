package main.java.controller;

import main.java.view.LoginView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ServerMultithread extends Thread{
    private Socket clientSocket = null;
    public ServerMultithread(Socket socket) {
        this.clientSocket = socket;
    }// end of constructor

    public void run(){
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            LoginView start = new LoginView();
            start.login(out, in);
            out.close();
            in.close();
        }catch (SocketException e){
            System.err.println("Socket Closed");
        }
        catch (Exception e){
            System.err.println("exception in input streams");
        }

    }// end of run
}
