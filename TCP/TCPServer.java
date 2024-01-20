package TCP;
import java.net.*;
import java.io.*;

public class TCPServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            System.err.println("Could not use the port: 8888.");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection...");

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Connection done.");
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received message: " + inputLine);
            
            // search for the input in the database
            String result = searchDatabase(inputLine);
            
            // send the result back to the client
            out.println(result);
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static String searchDatabase(String input) {
        String result = "Vehicle is not found";
        
        switch(input) {
            case "B001":
                result = "Seat, Ibiza, 2009, Orange";
                break;
            case "B002":
                result = "Hyundai, Kona, 2019, White";
                break;
            case "A001":
                result = "VW, Polo, 2005, Black";
                break;
            case "C002":
                result = "Audi, A6, 2020, Silver";
                break;
            case "C003":
                result = "BMW, X7, 2022, Brown";
                break;
        }
        
        return result;
    }
}
