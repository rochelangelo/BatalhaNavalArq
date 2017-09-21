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
    
    static int altura, largura, qtdNavios, limiteMaxNavios, qtdRestNavios;
    static int tabuleiro[][];
    static Scanner input = new Scanner(System.in);
    static Random aleatorio = new Random();
    
   
    
    public static void iniciarTamanhosDoTab(){
        tabuleiro = retornaTabuleiroVazio();
    }
    
    public static int[][] retornaTabuleiroVazio(){
        return new int[altura][largura];
    }
    
}
