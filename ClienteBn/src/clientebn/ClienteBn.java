/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientebn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author 20141D12GR0505
 */
public class ClienteBn {

    String h = "Felipe é maravilhoso kjkjkjk";
    
}



//!!!!! http://www.devmedia.com.br/como-criar-um-chat-multithread-com-socket-em-java/33639

//        
//        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
//        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());
//        
//        
//        Scanner teclado = new Scanner(System.in);
//        
//        String tabela = dados.read();
//        
//        while(!teclado.equals("sair")){
//            
//            resultado.close();
//            dados.close();
//            cliente.close();
//            
//        }