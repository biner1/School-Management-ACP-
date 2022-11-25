package main.java;

import main.java.controller.ServerSideSocket;
import main.java.model.*;
import main.java.controller.StudentList;
import main.java.view.LoginView;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;

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
