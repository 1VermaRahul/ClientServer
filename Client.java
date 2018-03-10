import java.io.*;
import java.net.*;

class Client {
 public static void main(String argv[]) throws Exception {
  String s;
  String modifiedSentence;
  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost", 6789);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  s = inFromUser.readLine();
  outToServer.writeBytes(s + '\n');
  modifiedSentence = inFromServer.readLine();
  System.out.println("from server: " + modifiedSentence);
  clientSocket.close();
 }
}
