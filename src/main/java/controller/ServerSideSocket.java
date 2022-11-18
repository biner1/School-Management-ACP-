package main.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import main.java.view.LoginView;
public class ServerSideSocket {

    public void startConnection(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
        }

        Socket clientSocket = null;
        try {
            System.out.println("waiting for client connection");
            clientSocket = serverSocket.accept();
            System.out.println("Connected to a client");
        } catch (IOException e) {
            System.err.println("Accept failed.");
        }

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            LoginView start = new LoginView();
            start.login(out, in);
        }catch (SocketException e){
            System.err.println("socket exception");
        }
        catch (Exception e){
            System.err.println("exception in input streams");
        }
    }

}
