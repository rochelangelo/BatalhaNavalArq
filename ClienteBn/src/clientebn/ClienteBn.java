/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientebn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        
        Socket cliente = new Socket("127.0.0.1", 1234);
        
        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());
        
        Scanner teclado = new Scanner(System.in);
        
        
        
        while(!teclado.equals("sair")){
            
            resultado.close();
            dados.close();
            cliente.close();
            
        }
                
    }
    
}
