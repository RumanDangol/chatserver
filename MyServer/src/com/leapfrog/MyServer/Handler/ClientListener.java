/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.Handler;

import com.leapfrog.MyServer.Command.ChatCommand;
import com.leapfrog.MyServer.Command.ListCommand;
import com.leapfrog.MyServer.Command.PublilcMessageCommand;
import com.leapfrog.MyServer.dao.UserDao;
import com.leapfrog.MyServer.dao.impl.UserDaoImpl;
import com.leapfrog.MyServer.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author ruman dangol
 */
public class ClientListener extends Thread {

    private UserDao userDao = new UserDaoImpl();
    private ClientHandler handler;

    private Socket socket;
    private PrintStream ps;
    private BufferedReader reader;
    private Client client;

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {

        this.socket = socket;
        this.handler = handler;
        ps = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {

            ps.print("Welcome to Server ");
            while(!doLogiin()){
                
            }
            String line = "";
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
//                if(line.equalsIgnoreCase(line)){
//                    Process process=new ProcessBuilder(line).start();
//                }

                System.out.println(line);
                ChatCommand cmd;
                if (line.equalsIgnoreCase("list")) {
                    cmd = new ListCommand();
                } else {

                    cmd = new PublilcMessageCommand();

                }
                cmd.setHandler(handler);
                cmd.execute(client, line);

            }
            handler.removeClient(client);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
    }

    private boolean doLogiin() throws IOException {
        ps.println("Enter your user name:");
        String name = reader.readLine();
        ps.println("Enter your password:");
        String password = reader.readLine();
        User user = userDao.login(name, password);
        if (user == null) {
            ps.println("Invalid User Name");
            return false;
        } else if (!user.isStatus()) {
            ps.println("Your account is not active");
            return false;
        } else {
            ps.println("Hello : " + name);

            client = new Client(name, socket);
            handler.addClient(client);
            System.out.println(name);
            return true;

        }

    }
//    public void privateMessage(Client client,String message ) throws IOException{
//        for(Client c: handler.getClients()){
//            if(!c.equals(client)){
//                PrintStream ps=new PrintStream(c.getSocket().getOutputStream());
//                ps.println(message);
//                
//            }
//        }
//    }
}
