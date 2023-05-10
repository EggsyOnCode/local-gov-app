package com.example.demo.chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author SHUBHAM
 */
public class Client {

    public static void main(String args[]) throws Exception
    {
        Socket sk=new Socket("127.0.0.1",5000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout=new PrintStream(sk.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (  true )
        {
            System.out.print("Client : ");
            s=stdin.readLine();
            sout.println(s);
            if ( s.equalsIgnoreCase("BYE") )
            {
                System.out.println("Connection ended by client");
                break;
            }
//            s=sin.readLine();
//            System.out.print("Server : "+s+"\n");

        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }

}