/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolocadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernanda Mendes
 */
public class LeitorArquivo {

    public List<String> lerArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        List<String> dadosClientes = new ArrayList<>();
        if (arquivo.exists()) {
            String linha;
            try {
                FileReader leitorAr = new FileReader(nomeArquivo);
                BufferedReader bufferA = new BufferedReader(leitorAr);
                linha = bufferA.readLine();
                while (linha != null) {
                    dadosClientes.add(linha);
                    linha = bufferA.readLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return dadosClientes;
    }
}
