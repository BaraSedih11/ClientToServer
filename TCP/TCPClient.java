package TCP;
import java.io.*;
import java.net.*;

public class TCPClient {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("BaraAlSedih", 8888);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: BaraAlSedih.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: BaraAlSedih.");
            System.exit(1);
        }

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            String response = in.readLine();
            System.out.println("Server Response: " + response);
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
