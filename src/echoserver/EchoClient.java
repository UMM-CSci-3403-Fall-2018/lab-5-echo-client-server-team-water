package echoserver;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient {
  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;

    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      Socket socket = new Socket(server, portNumber);

      DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
      Scanner scanner = new Scanner(System.in);
      byte k;
      DataInputStream inStream = new DataInputStream(socket.getInputStream());
      byte b;

      while(scanner.hasNextByte()){
        k = scanner.nextByte();
        outStream.writeByte(k);
        b = inStream.readByte();
        System.out.print(b);
      }

      socket.close();

    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }

  }
}
