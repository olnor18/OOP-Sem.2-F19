/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duffy
 */
public class ServerController implements Runnable {

    ServerSocket server;

    public void run() {
        while (true) {
            try {
                server = new ServerSocket(1025);
                Socket clientSocket = server.accept();
                Runnable clientHandler = new ClientHandlerThread(clientSocket);
                new Thread(clientHandler).start();

            } catch (IOException ex) {
                //Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("IO Error " + ex);
            }
        }
    }
}
