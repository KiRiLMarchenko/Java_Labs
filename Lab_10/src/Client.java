import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Game loop
            while (true) {
                // Perform game logic here
                // ...

                // Send the input to the server
                out.println("Input from client");

                // Receive the response from the server
                String response = in.readLine();
                System.out.println("Received from server: " + response);

                // Check game conditions and break the loop if necessary
                // if (gameOver) {
                //     break;
                // }
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startConnection("localhost", 8888);
    }
}