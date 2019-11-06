/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author bruno.191196
 */
public class CalculadoraNPR {
  private Stack s;
  
  public void iniciar() {
    entrada();
    saida();
  }
  
  private void entrada () {
    String arquivo = "Entrada.txt";
    try {
      String linha;
      FileReader fReader = new FileReader (arquivo);
      BufferedReader bReader = new BufferedReader(fReader);
      linha = bReader.readLine();
      String[] str = linha.split(" ");
      for (int i = str.length - 1; i >= 0; i--) {
        s.push(str[i]);
      }
      bReader.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("Não foi possível abrir o aquivo '" + arquivo + "'");
    }
    catch (IOException e) {
      System.out.println("Erro ao ler o arquivo " + arquivo + "'");
    }
  }

  private void saida () {
    String arquivo = "Saída.txt";
    try {
      FileWriter fWriter = new FileWriter(arquivo);
      BufferedWriter bWriter = new BufferedWriter(fWriter);
      String linha;
      while ((s.size() == 1 && Character.isDigit(s.peek().toString().charAt(0))) == false) {
        calculo();
      }
      linha = s.pop().toString();
      bWriter.write(linha);
      bWriter.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("Não foi possível abrir o aquivo '" + arquivo + "'");
    }
    catch (IOException e) {
      System.out.println("Erro ao ler o arquivo " + arquivo + "'");
    }
  }
  
  private void calculo () {
    String sinal = null;
    int n1, n2;
    n1 = Integer.parseInt(s.pop().toString());
    n2 = Integer.parseInt(s.pop().toString());
    sinal = s.pop().toString();
    if (sinal.equals("+")) {
      s.push(n1 + n2);
    } else {
      if (sinal.equals("-")) {
        s.push(n1 - n2);
      } else {
        if (sinal.equals("*")) {
          s.push(n1 * n2);
        } else {
          s.push(n1 / n2);
        }
      }
    }
  }
  
  CalculadoraNPR() {
    this.s = new Stack();
  }
}
