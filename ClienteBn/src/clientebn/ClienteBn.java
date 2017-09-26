/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientebn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20141D12GR0505
 */
public class ClienteBn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new ClienteBn("127.0.0.1", 1234)
    }
    
    private String host;
    private int porta;

    public ClienteBn(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }
    
    public void execulta() throws IOException{
        Socket cliente = new Socket(host, porta);
        System.out.println("Cliente conecetado ao servidor!");
        
        Recebedor recebedor = new Recebedor(cliente.getInputStream());
        new Thread(recebedor).start();
        
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        
        while(teclado.hasNextLine()){
            saida.println(teclado.nextLine());
        }
        
        saida.close();
        teclado.close();
        cliente.close();
    }
    
}



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