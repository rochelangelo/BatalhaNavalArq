/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientebn2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author corona
 */
public class ClienteBn2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        new ClienteBn2("127.0.0.1", 1234).execulta();
    }
    
    private String host;
    private int porta;

    public ClienteBn2(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }
    
    public void execulta() throws UnknownHostException, IOException{
        Socket cliente = new Socket(host, porta);
        System.out.println("Jogador2 conecetado ao servidor!");
        
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
