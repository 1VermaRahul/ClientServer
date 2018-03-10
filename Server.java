import java.io.*;
import java.net.*;

class Server {
 public static void main(String argv[]) throws Exception {
  String client;
  String capitalS;
  ServerSocket welcomeSocket = new ServerSocket(6789);

  while (true) {
   Socket connectionSocket = welcomeSocket.accept();
   BufferedReader inFromClient =
    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
   client = inFromClient.readLine();
   System.out.println("Received: " + client);
   capitalS = client.toUpperCase() + '\n';
   outToClient.writeBytes(capitalS);
  }
 }
}
