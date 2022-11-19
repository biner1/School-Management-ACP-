
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket serverConnection = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverConnection = new Socket("127.0.0.1", 6789);
            System.out.println("connected to: "+serverConnection);
        } catch (UnknownHostException e) {
            System.err.println("Don't know host: yohohoho.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: sv.");
            System.exit(1);
        }

        out = new PrintWriter(serverConnection.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput,toServer;
        System.out.println("connected");

        while ((userInput = in.readLine()) != null) {

		             boolean isServerAskForInput = userInput.equals("@r#");

		                 if (isServerAskForInput) {    // 1 if send then is ask for input from client
		                      System.out.print("you> ");
		                      toServer = stdIn.readLine();
		                      if(toServer.equals("exit()")){
								  out.close();
								          in.close();
								          stdIn.close();
        								serverConnection.close();
								  System.exit(1);
								  }
		                      out.println(toServer);
		                  }
		                  if(!isServerAskForInput)
		                  	System.out.println(":: " + userInput);
              }



    }
}
