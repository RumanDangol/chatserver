
package com.leapfrog.MyServer;

import com.leapfrog.MyServer.Handler.Client;
import com.leapfrog.MyServer.Handler.ClientHandler;
import com.leapfrog.MyServer.Handler.ClientListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
       int port = 5000;
       try{
           ServerSocket server=new ServerSocket(port);
           ClientHandler handler=new ClientHandler();
           
           System.out.println("Server is running at "+port);
           while(true){
               Socket socket=server.accept();
               System.out.println("Got Connection from "+ socket.getInetAddress().getHostAddress());
               
               ClientListener listener=new ClientListener(socket,handler );
               listener.start();
           }
       }catch(IOException ioe){
           System.out.println(ioe.getMessage());
           
       }
    }
    
}
