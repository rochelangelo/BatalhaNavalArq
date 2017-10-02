/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorbn;

import Bn.Tabuleiro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 20141D12GR0505
 */
public class ServidorBn extends Thread {
    
    private static ArrayList<BufferedWriter> clientes;
    private static ServerSocket servidor;
    private String nome;
    private Socket cliente;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;
    
    public ServidorBn(Socket con) {
        this.cliente = con;
        try {
            in = cliente.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {

        try {

            String msg;
            OutputStream ou = this.cliente.getOutputStream();
            Writer ouw = new OutputStreamWriter(ou);
            BufferedWriter bfw = new BufferedWriter(ouw);
            clientes.add(bfw);
            nome = msg = bfr.readLine();

            while (!"Sair".equalsIgnoreCase(msg) && msg != null) {
                msg = bfr.readLine();
                sendToAll(bfw, msg);
                System.out.println(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public void sendToAll(BufferedWriter bwSaida, String msg) throws IOException {
        BufferedWriter bwS;

        for (BufferedWriter bw : clientes) {
            bwS = (BufferedWriter) bw;
            if (!(bwSaida == bwS)) {
                bw.write(nome + " -> " + msg + "\r\n");
                bw.flush();
            }
        }
    }
    
     public static void main(String[] args) {

        try {
            servidor = new ServerSocket(1234);
            clientes = new ArrayList<BufferedWriter>();
            while (true) {
                System.out.println("---Servidor aberto a conexão!---" + "\n   Aguardando conexão");
                Socket cliente = servidor.accept();
                System.out.println("\nConexão com Cliente: " + cliente.getInetAddress().getHostAddress());
                Thread t = new ServidorBn(cliente);
                t.start();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }      
    
    
}
//    public static void main(String args[]) throws IOException{
//		
//        
//            String tabela;
//            
//            Scanner sc = new Scanner(System.in);
//            
//            ServerSocket servidor = new ServerSocket(1234);
//            System.out.println("---Servidor aberto a conexão!---" + "\n   Aguardando conexão");
//            Socket cliente = servidor.accept();
//            System.out.println("\nConexão com Cliente: " + cliente.getInetAddress().getHostAddress());
//                
//            ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
//            ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());
//            
//            while (!sc.equals("sair")) {
//                Tabuleiro.iniciarTamanhosDoTab();
//                Tabuleiro.retornarTabuleiroComNavios();
//                Tabuleiro.inserirNavios();
//                tabela = Tabuleiro.exibirTabuleiro();
//            }
//            
//            resultado.close();
//            dados.close();
//            cliente.close();
//            servidor.close();
//		
//	}

//Guadar essas linhas pra condiçoes de uso futuras
//ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
//        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());
//
//        Scanner sc = new Scanner(System.in);
//
//        String tabela;
//
//
//        resultado.writeBytes(tabela);
//        resultado.flush();
//
//        resultado.close();
//        dados.close();
//        cliente.close();
//        servidor.close();
        