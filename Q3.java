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
        
        BufferedReader leitor = new BufferedReader (new FileReader (in));
        BufferedWriter escritor = new BufferedWriter (new FileWriter (out));
        
        int M = Integer.parseInt(leitor.readLine().trim());      
            
        String [] palavras = leitor.readLine().split(" ");
        
        String temp = "";
		
		int tam = 0;
        
        for (int x = 0; x < palavras.length; x++) {
            
            temp = temp + palavras[x] + " ";	
			tam += palavras[x].trim().length();
            
            if (tam > M) {
		 
				temp = temp.trim();
                
				if (temp.contains(" ")) {
					
					escritor.write(temp.substring(0, temp.lastIndexOf(" ")));
					
					String excesso = temp.substring((temp.lastIndexOf(" ")+1), temp.length());
					
					temp = excesso + " ";
					tam = excesso.length();
					
				} else {
					
					escritor.write(temp);
					temp = "";
					tam = 0;
					
				}
                
                escritor.newLine();
            } 
        }
        
        if (temp.length() != 0) {
            
            escritor.write(temp);
            
        }
        
        escritor.flush();
        escritor.close();
        
        leitor.close();
    }
}
