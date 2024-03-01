import java.io.*;
import java.math.*;
import java.util.*;


public class Javafile{

    public static void main(String[] args){

        String input = "3X3 XXO OO- OXX";
        int indexSpace = input.indexOf(' ');
        String gridSize  = input.substring(0, indexSpace);
        int xwin = 0;
        int owin = 0;
        int invalid = 0;

        //get grid size from the string

        char rowSizeChar = gridSize.charAt(0);
        int rowSize = rowSizeChar - '0';
        char colSizeChar = gridSize.charAt(2);
        int colSize = colSizeChar - '0';

        //get remaining substring from input
        String restOfString = input.substring(indexSpace+1).replace(" ","");

        //convert string to character array to be populated onto grid;
        char[] characters = restOfString.toCharArray();
        char[][] gridBoard = new char[rowSize][colSize];
        int index = 0;
        for (int i=0; i<rowSize; i++){
            for (int j=0; j<colSize; j++){
                gridBoard[i][j]= characters[index++];
                System.out.print(gridBoard[i][j]+ " ");
            }
            System.out.print("\n");
            
        }
        // check for invalid Board Size, Invalid alternate play (ie each player makes one move at a time)
        //***code here */

        // check for row win
        char initialPlay = '-';
        int rowCount = 1;  //keeps track of row win
         System.out.println("Row initial position Values");
        for(int r=0; r<rowSize; r++){
            initialPlay = gridBoard[r][0];
            for(int c=1; c<colSize; c++){
                if(initialPlay == gridBoard[r][c]){
                    rowCount +=1;
                }else{
                    rowCount = 0;
                    break; // stop and move to next row;
                }
            }
            if(rowCount == colSize && initialPlay == 'X'){
                xwin += 1; // x wins, from row
            }else if(rowCount == colSize && initialPlay == 'O') {
                owin += 1;
            }
            //if no win check the columns for winner
           
            System.out.println(initialPlay);

        }

         // check for column win
        int colCount = 1;  //keeps track of col win
        char initialColPlay= '-';
        int columnCheck = colSize;
         int nextCol = 0;
          System.out.println("column initial Position Values" );
        while (columnCheck > 0){
            for(int rowLoop=0; rowLoop<rowSize; rowLoop++){
                for(int downwardMove=nextCol; downwardMove<=nextCol; downwardMove++){
                    initialColPlay = gridBoard[0][downwardMove];
                    if(initialColPlay == gridBoard[rowLoop][downwardMove]){
                        colCount +=1;
                    }else{
                        colCount=0;
                        break;
                    }
                    if (initialColPlay == 'X' && colCount == colSize){
                        xwin +=1;
                    }else if((initialColPlay == 'O' && colCount == colSize)){
                        owin +=1;
                    }
                }
               
            }
            nextCol +=1;
            columnCheck--;
            System.out.println(initialColPlay);
        }
       
        //check for diagonal Left win
        char initialDiagonalLeft = gridBoard[0][0];
        int diagonalLeftCount = 1;
        System.out.println("Diagonal Left  Position Values");
        for(int d=0; d<rowSize; d++){
            System.out.println(gridBoard[d][d]);
            if(initialDiagonalLeft == gridBoard[d][d]){
                diagonalLeftCount +=1;
            }else{
                diagonalLeftCount =0;
                break;
            }
             if (initialDiagonalLeft == 'X' && diagonalLeftCount == rowSize){
            xwin +=1; 
            }else if (initialDiagonalLeft == 'O' && diagonalLeftCount == rowSize){
                owin +=1;
            
            }
        }
       
        
        //check for diagonal Right win
        char initialDiagonalRight= gridBoard[0][colSize-1];
         int diagonalRightSize = colSize;
        int diagonalRightCount = 1;
        System.out.println("Diagonal Right Position Values");
        for(int d=0; d<rowSize; d++){
            diagonalRightSize -= 1;
            System.out.println(gridBoard[d][diagonalRightSize]);
            if(initialDiagonalRight == gridBoard[d][diagonalRightSize]){
                diagonalRightCount +=1;
            }else{
                diagonalRightCount =0;
                break;
            }
            if (initialDiagonalRight == 'X' && diagonalRightCount == rowSize){
            xwin +=1; 
            
            }else if (initialDiagonalRight == 'O' && diagonalRightCount == rowSize){
                owin += 1;
            }

        }

        System.out.print("Player X : "+  xwin +"\n");
        System.out.println("Player O : "+  owin);

    }
    

}


