/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Ahmed Abdelaziz
 */
public class ChatHandler extends Thread{
    DataInputStream dis;
    PrintStream ps;
    String str;
    static Vector<ChatHandler> clientsVector = new Vector<>();
    public ChatHandler(Socket cs,String ns)
    {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clientsVector.add(this);
            ServerFrame.clientsName.add(ns);
            ServerFrame.numClient = clientsVector.size();
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                str = dis.readLine();
                if("@#@#".equals(str.substring(0, 4))) {
                    sendMessageToAll("---------------------------------------------------------------");
                    sendMessageToAll(str.substring(4, str.length())+" .... Disconnected :(");
                    sendMessageToAll("---------------------------------------------------------------");
                    ServerFrame.clientsName.remove(clientsVector.indexOf(this));
                    clientsVector.remove(this);
                    ServerFrame.numClient = clientsVector.size();
                    Thread.currentThread().stop();
                }else {
                    sendMessageToAll(str);
                }  
            } catch (IOException ex) {
                ServerFrame.clientsName.remove(clientsVector.indexOf(this));
                clientsVector.remove(this);
                ServerFrame.numClient = clientsVector.size();
                Thread.currentThread().stop();
                ex.printStackTrace();
            }
        }
    }
    void sendMessageToAll(String msg)
    {
            for(ChatHandler ch : clientsVector)
            {
                    ch.ps.println(msg);
            }
    }
}
