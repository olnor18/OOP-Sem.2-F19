/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duffy
 */
public class ClientHandlerThread implements Runnable{

    private Socket clientSocket;

    public ClientHandlerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        
        try {
            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
            output.writeBoolean(true);
            output.writeObject(DomainHandler.getDomainHandler().parseQuery((String[])input.readObject()));
            
        } catch (IOException ex) {
            //Logger.getLogger(ClientHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("IO error " + ex);
        }
        
    }
    
}
