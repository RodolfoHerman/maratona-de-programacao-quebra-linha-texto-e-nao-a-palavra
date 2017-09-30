/* --------------------------------------------------------------- */
/*                                                                 */
/*                            _       _                            */
/*                           |_| | | |                             */
/*                           |   |_| |_                            */
/*                      ====================                       */
/*                                                                 */
/*                                                                 */
/* --------------------------------------------------------------- */
/*        PUC-MG, Unidade COREL. Disciplina de AED III	           */
/*               Graduação em Ciência da Computação                */
/*         2014 Coração Eucarístico, Belo Horizonte - MG           */
/*                     http://www.pucminas.br/                     */
/*                                                                 */
/*        Author: Rodolfo Herman;                                  */
/*                                                                 */
/*                                                                 */
/* --------------------------------------------------------------- */

/* --------------------------------------------------------------- */
/*					ALGORITMO: MARATONA DE PROGRAMACAO      	   */
/* --------------------------------------------------------------- */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Q3 {

    private static final String in = "in.txt";
    private static final String out = "out.txt";
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader leitor = new BufferedReader(new FileReader(in));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(out));
        
        int m = Integer.parseInt(leitor.readLine().trim());
        String [] palavras = leitor.readLine().split(" ");
        
        int tamanho = 0;
        String temp = "";
        
        for(String palavra: palavras) {
            
            tamanho += palavra.length();
            temp = temp.concat(palavra).concat(" ");
            
            if(tamanho >= m) {
                
                temp = temp.trim();
                
                if(temp.contains(" ")) {
                    
                    String texto = temp.substring(0, temp.lastIndexOf(" "));
                    String termo = temp.substring(temp.lastIndexOf(" ")+1);
                    
                    escritor.write(texto);

                    tamanho = termo.length();
                    temp = termo.concat(" ");
                    
                } else {
                    
                    escritor.write(temp);
                
                    tamanho = 0;
                    temp = "";                    
                }
                
                escritor.newLine();
            } 
        }
        
        if(tamanho != 0) {
            
            escritor.write(temp);
        }
        
        escritor.flush();
        leitor.close();
        escritor.close();
    }
}
