package main.java;

import main.java.controller.ServerSideSocket;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        try {
            ServerSideSocket s = new ServerSideSocket();
            s.startConnection();
        } catch (NullPointerException e){
            System.err.println("socket not created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
