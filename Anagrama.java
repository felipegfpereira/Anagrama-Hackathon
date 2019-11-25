        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.Scanner;
        import java.io.LineNumberReader;
        import java.util.Arrays;
        
        public class Anagrama
        {
            
            public static boolean verificaLetras(String str) //Função para verificar caracteres invalidos
            {
                    return str.matches("[a-zA-Z]+");
            }
          
            
            public static void main(String[] args) 
            {
                 Scanner teclado = new Scanner(System.in);
                 String nomeArquivoAnagrama = "Palavras.txt";
                 String linha = new String ();
                 String palavra;
                 //---------------------------------------------------------------------------------------//
                 System.out.printf("Informe a palavra:\n");
                 palavra = (teclado.nextLine()).toUpperCase().replaceAll(" ",""); // retira os espaços 
                
                 while(palavra.length() >= 16)//Prende usuário no loop até digitar quantidade válida de caracteres
                 {
                    System.out.printf("Por favor, inserir palavra com menos de 16 caracteres.\n");
                    System.out.printf("Informe a palavra:\n");
                    palavra = (teclado.nextLine()).toUpperCase().replaceAll(" ","");
                 }
                
                 if(verificaLetras(palavra))
                 {
                     System.out.printf("\nOs anagramas da palavra " + palavra + " são:\n");
                     
                     try 
                     {
                         //Percorre o arquivo para descobrir o numero de linhas
                         String nomeArquivo = "Palavras.txt"; 
                         FileReader arquivoLinhas = new FileReader(nomeArquivo);
                         LineNumberReader lnr = new LineNumberReader(arquivoLinhas);
                         lnr.skip(Integer.MAX_VALUE);
                         int qtdLinha = 0;
                         qtdLinha = lnr.getLineNumber() + 1;
                         arquivoLinhas.close();
                         //fecha o arquivo
                         
                         String[] arrayLinhas = new String[qtdLinha];
                                    
                         FileReader arquivoPalavras = new FileReader(nomeArquivoAnagrama);
                         BufferedReader listaPalavras = new BufferedReader(arquivoPalavras);
                         
                            for (int i = 0; i < qtdLinha; i++)
                                    {
                                        linha = listaPalavras.readLine(); //Lê cada linha
                                        arrayLinhas[i] = linha; //Armazena cada linha em um array
                                        
                                        if(!palavra.equals(linha))//Verifica se as duas palavras não são iguais
                                        {
                                            
                                            if(palavra.length() == linha.length())// Verifica se tamanho das palavras é igual
                                            {
                                                int contaLetra = 0; //contador para quantidade de letras
                                                char letrasPalavra[] = palavra.toCharArray(); // Divide e converte a palavra em um array de CHAR
                                                char letrasLista[] = linha.toCharArray(); //Divide e converte a linha em um array de CHAR
                                                
                                                Arrays.sort(letrasPalavra); //Arruma o array da palavra digitada
                                                Arrays.sort(letrasLista); // Arruma o array da palavra da lista
                                                for(int j = 0; j < linha.length(); j++)
                                                {
                                                    if(letrasPalavra[j] == letrasLista[j])//Verifica se o valor das posições é igual
                                                            contaLetra++;
                                                        else //sai do loop para evitar verificação desnecessária
                                                        {
                                                            j = linha.length(); 
                                                            contaLetra = 0; // zera contador
                                                        }
                                                }
                                                if(contaLetra == linha.length())// Imprime anagrama na tela
                                                {
                                                    //System.out.println(palavra + " e " + linha + " são anagramas. "); 
                                                    System.out.println(linha); 
                                                    contaLetra = 0;
                                                }
                                                
                                            }//fimDoIfLength
                                            
                                        }//fimDoEquals
                                        
                                    }//fimDoFor 
                                    
                                }//fimDoTry
                                    catch (IOException e) 
                                    {   //CASO ERRO
                                        System.err.printf("Erro na abertura do arquivo: %s.\n",
                                        e.getMessage());
                                    }  
                                    
                  }//fimDoIF
                   else
                     {
                         System.out.println(" é um caracter inválido, encerrando aplicação.");
                     }
                     
            }//fimDoMain 
            
        }//ClassEnd