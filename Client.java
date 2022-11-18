
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 6789);
            System.out.println("connected to: "+echoSocket);
        } catch (UnknownHostException e) {
            System.err.println("Don't know host: yohohoho.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: sv.");
            System.exit(1);
        }

        out = new PrintWriter(echoSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("connected");

        while ((userInput = in.readLine()) != null) {

		             boolean isServerAskForInput = userInput.equals("@r#");
		                 if (isServerAskForInput) {    // 1 if send then is ask for input from client
		                      System.out.print("you> ");
		                      out.println(stdIn.readLine());
		                  }
		                  if(!isServerAskForInput)
		                  	System.out.println(":: " + userInput);
              }


        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
