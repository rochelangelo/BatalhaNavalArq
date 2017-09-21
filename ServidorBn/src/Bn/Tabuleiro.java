/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bn;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 20141D12GR0505
 */
public class Tabuleiro {
    
    static int altura = 24, largura = 24;
    static int qtdNavios = 200, qtdRestNavios;
    static int tabuleiro[][];
    static Scanner input = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void iniciarTamanhosDoTab(){
        tabuleiro = retornaTabuleiroVazio();
    }
    
    public static int[][] retornaTabuleiroVazio(){
        return new int[altura][largura];
    }
    
    public static void inserirNavios(){
        tabuleiro = retornarTabuleiroComNavios();
    }
    
    public static int[][] retornarTabuleiroComNavios(){
        int x = 0, y = 0;
        int[][] novaTabela = retornaTabuleiroVazio();
        qtdRestNavios = qtdNavios;
        do{ 
            x = 0;
            y = 0;
            for(int [] linha : novaTabela){
                for(int coluna : linha){
                    if(aleatorio.nextInt(100) <= 10){
                        if(coluna == 0){
                            novaTabela[x][y] = 1;
                            qtdRestNavios--;
                            break;
                        }
                        if(qtdRestNavios <= 0){
                            break;
                        }
                    }
                    y++;
                }
                y = 0;
                x++;
                if(qtdRestNavios <= 0){
                    break;
                }
            }
        }while(qtdRestNavios > 0);
        
        return novaTabela;
    }
    
    public static String exibirTabuleiro(){
        System.out.println("----BATALHA NAVAL----\n");
        char letraColuna = 65; //65 é o numero do caracter a
        String letrasTab = "   ";
        for(int i = 0 ; i < largura ; i++){
            letrasTab += (letraColuna++) + " ";
        }
        System.out.println(letrasTab);
        String linhaTab = "";
        int numeroLinha = 1;
        int[][] tab = retornarTabuleiroComNavios();
        for(int [] linha : tab){
            if(numeroLinha < 10){
                linhaTab = (numeroLinha++) + " |";
            }else{
                linhaTab = (numeroLinha++) + "|";
            }
            for(int coluna : linha){
                switch(coluna){ //Verifica estado da coluna
                    case 0: //está vazio ou sem ação
                        linhaTab += " |";
                        break;
                    case 1: //tem navio escondido
                        linhaTab += " |";
                        break;
                    case 2: //erro
                        linhaTab += "X|";
                        break;
                    case 3: //acerto
                        linhaTab += "N|";
                        break;
                }
            }
            System.out.println(linhaTab);
        }
        System.out.println(letrasTab);
        
        return "Tabela";
    }
    
}
