package com.mycompany.terminal;

import java.io.*;
import java.net.*;

public class ClientSocket {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        try (Socket clientSocket = new Socket("localhost", 8080)) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence + '\n');
            modSentence = inFromServer.readLine();
            
            System.out.println("FROM SERVER: " + modSentence);
        }
    }
}
