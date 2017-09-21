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
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 20141D12GR0505
 */
public class ServidorBn {

    public static void main(String[] args) throws IOException {
        new ServidorBn(1234).execulta();
    }

    private int porta;
    private List<PrintStream> clientes;

    public ServidorBn(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void execulta() throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Servidor aberto a conexão na porta " + this.porta + "!" + "\n      Aguardando conexão");
        
        while(true){
            //aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            
            //add saida do cliente a lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);
            
            //tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }
    }
    
    public void distribuiMensagem(String msg){
        //envia msg para todos os clientes
        for(PrintStream cliente : this.clientes){
            cliente.println(msg);
        }
    }
}
//Guadar essas linhas pra condiçoes de uso futuras
//ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
//        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());
//
//        Scanner sc = new Scanner(System.in);
//
//        String tabela;
//
//        Tabuleiro.iniciarTamanhosDoTab();
//        Tabuleiro.retornarTabuleiroComNavios();
//        Tabuleiro.inserirNavios();
//        tabela = Tabuleiro.exibirTabuleiro();
//
//        resultado.writeBytes(tabela);
//        resultado.flush();
//
//        resultado.close();
//        dados.close();
//        cliente.close();
//        servidor.close();
        