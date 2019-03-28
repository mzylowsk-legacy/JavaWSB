package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Sudoku {
    
     
    public static void main(String[] args) throws FileNotFoundException {
        int[][] sudoku = new int[9][9];
        int isValid = 255;
       
        // Wczytaæ tutaj wartoœci z pliku sudoku.txt do tablicy "sudoku" (1 punt)
        File plik = new File("sudoku.txt");
        Scanner in = new Scanner(plik);

        for (int i= 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
               sudoku[i][j] = in.nextInt(); 
            }
        }
               
        

        // Wypisaæ sudoku na ekran (10 lini, ka¿da cyfra oddzielona spacj¹)
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
        System.out.println();
        }  
        // Sprawdziæ poprawnoœæ sudoku.
        // UWAGA: Jeœli sudoku jest poprawne wartoœci is_valid nale¿y przypisaæ 0.
        // Jeœli sudoku nie jest poprawne wartoœæ is_valid nale¿y przypisaæ 1.
        // Jeœli sudoku jest nie kompletne, nale¿y przypisaæ wartoœæ 2.
       
       
        int kolumna=0, wiersz=0, kolumnaSuma=0, wierszSuma=0;
        
        
        for(kolumna = 0; kolumna < 9; kolumna++)  {
            for(wiersz = 0; wiersz < 9; wiersz++)  {
                if (sudoku[kolumna][wiersz]==0){
                    isValid=2;
                    System.exit(isValid);
                }
            }
        }
        
       
      
        for(kolumna = 0; kolumna < 9; kolumna++)  {
            for(wiersz = 0; wiersz < 9; wiersz++)  {
                kolumnaSuma = kolumnaSuma + sudoku[wiersz][kolumna];
            }
        if(kolumnaSuma!=45){
            isValid=1;
       
        System.exit(isValid);
        }
        kolumnaSuma = 0;
        }
    
        for(wiersz = 0; wiersz < 9; wiersz++)  {
            for(kolumna = 0; kolumna < 9; kolumna++)  {
                wierszSuma = wierszSuma + sudoku[wiersz][kolumna];
        }
        if(wierszSuma != 45){
            isValid=1;
            System.exit(isValid);
        }
        wierszSuma = 0;
        }
        isValid=0;
        System.exit(isValid);
    }
  
}