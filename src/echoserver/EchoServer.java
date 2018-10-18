package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
  public static final int portNumber = 6013;

  public static void main(String[] args) {
    try {
      // Start listening on specified port
      ServerSocket socket = new ServerSocket(portNumber);

      while (true) {
        Socket client = socket.accept();
        System.out.println("Client connected");

        // c for client
        int c;

        while ((c = client.getInputStream().read()) != -1) {
          client.getOutputStream().write((byte) c);
        }

        client.close();
        System.out.println("Client disconnected");
      }
    } catch (IOException ioe) {
      System.out.println(":(");
      System.err.println(ioe);
    }
  }
}
