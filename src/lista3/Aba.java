/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Bruno
 */
public class Aba {
  String urlAtual;
  Stack pgsAnteriores, pgsPosteriores;
  
  public void alterarUrl (ArrayList<String> historico, String novaUrl) {
    if (urlAtual != null) {
      historico.add(urlAtual);
      pgsAnteriores.push(urlAtual);
    }
    urlAtual = novaUrl;
    System.out.println("Página redirecionada para " + novaUrl);
    pgsPosteriores.clear();
  }
  
  public void retornar (ArrayList<String> historico) {
    if (pgsAnteriores.empty() == false) {
      if (urlAtual != null) {
        pgsPosteriores.push(urlAtual);
      }
      urlAtual = pgsAnteriores.pop().toString();
      System.out.println("Página redirecionada para " + urlAtual);
      historico.add(urlAtual);
    } else {
      System.out.println("Não há páginas anteriores para as quais você possa retornar");
    }
  }
  
  public void avançar (ArrayList<String> historico) {
    if (pgsPosteriores.empty() == false) {
      if (urlAtual != null) {
        pgsAnteriores.push(urlAtual);
      }
      urlAtual = pgsPosteriores.pop().toString();
      System.out.println("Página redirecionada para " + urlAtual);
      historico.add(urlAtual);
    } else {
      System.out.println("Não há páginas posteriores para as quais você possa retornar");
    }
  }
  
  Aba () {
    this.pgsAnteriores = new Stack();
    this.pgsPosteriores = new Stack();
  }
}
