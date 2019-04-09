/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duffy
 */
public class CommunicationInterfaceImpl implements CommunicationInterface {

    List<String[]> list = new ArrayList();

    enum Commands {
        LOGIN(3, "login"),
        GETCALENDER(4, "getCalender"),
        MEDICIN(2, "getMedicin"),
        USERLIST(3, "getUserlist");

        int count = 0;
        String command;

        Commands(int count, String command) {
            this.count = count;
            this.command = command;
        }

        public int getCount() {
            return this.count;
        }

        public String getCommand() {
            return this.command;
        }

    }

    @Override
    public List<String[]> sendQuery(String[] query) {
        if (checkQuery(query)) {
            try {
                Socket clientSocket= new Socket("localhost", 1025);
                
                //InputStream input = clientSocket.getInputStream();
                ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());                
                if (input.readBoolean()){
                    output.writeObject(query);
                    return ((List<String[]>)input.readObject());
                }
                    
            } catch (IOException ex) {
//                Logger.getLogger(CommunicationInterfaceImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("I/ O error " + ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(CommunicationInterfaceImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Input error " + ex);
            }
        }
        return null;
    }

    public boolean checkQuery(String[] query) {
        for (Commands com : Commands.values()) {
            if (query[0] == com.getCommand() && query.length == com.count) {
                return true;
            }
        }
        return false;
    }
}
