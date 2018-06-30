package projetolocadora;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ArquivoLocadora {

    String linha = new String();
    String nomeArquivo = "C:\\Arquivos_entrada\\teste1.txt";
    File arquivo = new File(nomeArquivo);
    Path caminho = Paths.get("C:\\Arquivos_saida\\output.txt");
    String texto;

    SouthCar south = new SouthCar();
    NorthCar north = new NorthCar();
    WestCar west = new WestCar();

      
    
    public void ReceberArquivo() {
        LeitorArquivo la = new LeitorArquivo();
        List<String> dadosClientes = la.lerArquivo(nomeArquivo);
        
        if(dadosClientes != null && !dadosClientes.isEmpty()){
            for(String clienteAtual : dadosClientes){
                    List<String> dadosConta = Arrays.asList(clienteAtual.split(":"));
                    String tipoCarro = dadosConta.get(0);
                    int numPessoas = Integer.parseInt(dadosConta.get(1));
                    List<String> datas = Arrays.asList(dadosConta.get(2).split(","));
                    int diasNormais = 0;
                    int diasFds = 0;
                    
                    for (String data : datas) {
                        int mes = monthToInteger(data.substring(2, 5));
                        Calendar date = new GregorianCalendar(Integer.parseInt(data.substring(5, 9)), mes, Integer.parseInt(data.substring(0, 2)));
                        if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                            diasFds++;
                        } else {
                            diasNormais++;
                        }
                      
                    }
                   

                    
                        if (numPessoas <= 2) {
                            // Comparar precos de todos os tipos de carros
                            double southPrice = south.calcularValor(tipoCarro, diasNormais, diasFds);
                            double northPrice = north.calcularValor(tipoCarro, diasNormais, diasFds);
                            double westPrice = west.calcularValor(tipoCarro, diasNormais, diasFds);
                            double menorPreco = southPrice;
                            if (westPrice < menorPreco) {
                                menorPreco = westPrice;
                            }
                            if (northPrice < menorPreco) {
                                menorPreco = northPrice;
                            }
                            if (menorPreco == southPrice) {
                                texto = "CARRO COMPACTO:SouthCar ";
                            } else if (menorPreco == northPrice) {
                                texto = "SUV:NorthCar " + northPrice;
                            } else if (menorPreco == westPrice) {
                                texto = "ESPORTIVO:WestCar";
                            }
                        } else if (numPessoas > 2 && numPessoas <= 4) {
                            double southPrice = south.calcularValor(tipoCarro, diasNormais, diasFds);
                            double northPrice = north.calcularValor(tipoCarro, diasNormais, diasFds);
                            double menorPreco = southPrice;
                            if (northPrice < menorPreco) {
                                menorPreco = northPrice;
                            }
                            if (menorPreco == southPrice) {
                                texto = "CARRO COMPACTO:SouthCar";
                            } else if (menorPreco == northPrice) {
                                texto = "SUV:NorthCar";
                            }
                        } else if (numPessoas > 4 && numPessoas <= 7) {
                            double northPrice = north.calcularValor(tipoCarro, diasNormais, diasFds);
                            texto = "SUV:NorthCar";
                      

                        }
                    
                    byte[] textoEMByte = texto.getBytes();
                    try {
                        Files.write(caminho, textoEMByte);
                    } catch (Exception e) {

                    }
            }
        
        
        }
        
        
        if (arquivo.exists()) {
            List<String> dadosConta = new ArrayList<String>();
            try {

                FileReader leitorAr = new FileReader(nomeArquivo);
                BufferedReader bufferA = new BufferedReader(leitorAr);
                linha = bufferA.readLine();
                while (linha != null) {
                    dadosConta.add(linha);
                    System.out.println(linha);
                    

                    linha = bufferA.readLine();
                }

            } catch (Exception e) {
            }
        }

    }

    private static Integer monthToInteger(String mes) {
        int mesInteiro = 0;
        switch (mes) {

            case "Jan":
                mesInteiro = 0;
                break;
            case "Fev":
                mesInteiro = 1;
                break;
            case "Mar":
                mesInteiro = 2;
                break;
            case "Apr":
                mesInteiro = 3;
                break;
            case "Mai":
                mesInteiro = 4;
                break;
            case "Jun":
                mesInteiro = 5;
                break;
            case "Jul":
                mesInteiro = 6;
                break;
            case "Ago":
                mesInteiro = 7;
                break;
            case "Set":
                mesInteiro = 8;
                break;
            case "Out":
                mesInteiro = 9;
                break;
            case "Nov":
                mesInteiro = 10;
                break;
            case "Dez":
                mesInteiro = 11;
                break;
            default:
                mesInteiro = -1;
                break;
        }
        return mesInteiro;
    }
}
