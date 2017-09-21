/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorbn;

import Bn.Tabuleiro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 20141D12GR0505
 */
public class ServidorBn {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(1234);
        System.out.println("---Servidor aberto a conexão!---" + "\n   Aguardando conexão");
        Socket cliente = servidor.accept();
        System.out.println("\nConexão com Cliente: " + cliente.getInetAddress().getHostAddress());
        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());
        
        Scanner sc = new Scanner(System.in);
        
        
        while(!sc.equals("sair")){
            
        }
        
        resultado.close();
        dados.close();
        cliente.close();
        servidor.close();
        
    }
    
}
