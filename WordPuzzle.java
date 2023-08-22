import java.util.Scanner;
import java.io.*;

public class WordPuzzle {

    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][]
    public static char matrix[][], output[][];
    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
        /*
        must have a base case
        once you find the first letter of the word
            - you must check for the second letter in all 8 directions
            - if you find the second letter then you call the function again
            - if you dont find it, write a return statement that sends you back to the base function to look for another instance of the first letter of the word
            - rinse and repeat
        if you find an instance of the first letter where it could potentially be the word
            - you track where that second letter was relative to the first letter
                - was it right across, below, above, diagonal, etc
            - after that, you continue going down that path until the length of the word has been met
            - then you begin printing where each letter was 

         */
        for (int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == word.charAt(0))
                {
                    if(i + word.length() <= matrix.length && j - word.length() >= 0)
                    {
                        if (matrix[i + 1][j - 1] == word.charAt(1)) //if the second letter is diagonally bottom left
                        {
                            int index = 2;
                            // int occurrences = 0;
                            boolean flag = true;

                            while (index < word.length()) {


                                if (matrix[i + index][j - index] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i + c][j - c] = matrix[i + c][j - c];
                                }
                            }


                            break;
                        }
                    }
                    if(j - word.length() >= 0)
                    {
                        if (matrix[i][j - 1] == word.charAt(1)) // if second letter is to the left
                        {
                            int index = 2;
                            boolean flag = true;

                            while (index < word.length()) {


                                if (matrix[i][j - index] == word.charAt(index)) {
                                    index++;
                                }
                                else
                                {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i][j - c] = matrix[i][j - c];
                                }
                            }


                            break;
                        }
                    }

                    if(i - word.length() >= 0 && j - word.length() >= 0)
                    {
                        if (matrix[i - 1][j - 1] == word.charAt(1)) // if second letter is to the top left
                        {
                            int index = 2;
                            boolean flag = true;
                            while (index < word.length()) {


                                if (matrix[i - index][j - index] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i - c][j - c] = matrix[i - c][j - c];
                                }
                            }


                            break;
                        }
                    }

                    if(i - word.length() >= 0)
                    {
                        if (matrix[i - 1][j] == word.charAt(1)) // if second letter is to the top
                        {
                            int index = 2;
                            boolean flag = true;

                            while (index < word.length()) {


                                if (matrix[i - index][j] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i - c][j] = matrix[i - c][j];
                                }
                            }


                            break;
                        }
                    }

                    if(i - word.length() >= 0 && j + word.length() <= matrix[0].length)
                    {
                        if (matrix[i - 1][j + 1] == word.charAt(1)) // if second letter is to the top right
                        {
                            int index = 2;
                            boolean flag = true;


                            while (index < word.length()) {


                                if (matrix[i + index][j + index] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i + c][j + c] = matrix[i + c][j + c];
                                }
                            }

                            break;
                        }
                    }
                    if(j + word.length() <= matrix[0].length)
                    {
                        if (matrix[i][j + 1] == word.charAt(1)) // if second letter is to the right
                        {
                            int index = 2;
                            boolean flag = true;

                            while (index < word.length()) {


                                if (matrix[i][j + index] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i][j+c] = matrix[i][j + c];
                                }
                            }

                            break;
                        }
                    }
                    if(i + word.length() <= matrix.length && j + word.length() <= matrix[0].length)
                    {
                        if (matrix[i + 1][j + 1] == word.charAt(1)) // if second letter is to the bottom right
                        {
                            int index = 2;
                            boolean flag = true;


                            while (index < word.length()) {


                                if (matrix[i + index][j + index] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i + c][j + c] = matrix[i + c][j + c];
                                }
                            }
                            break;
                        }
                    }
                    if(i + word.length() <= matrix.length) {
                        if (matrix[i + 1][j] == word.charAt(1)) // if second letter is to the bottom
                        {
                            int index = 2;
                            boolean flag = true;


                            while (index <= word.length()) {


                                if (matrix[i + index][j] == word.charAt(index)) {
                                    index++;
                                } else {
                                    flag = false;
                                    break;
                                }

                            }
                            if (flag) {
                                for (int c = 0; c < word.length(); c++) {
                                    output[i + c][j] = matrix[i + c][j];
                                }
                            }
                            break;
                        }
                    }


                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //let us use command line argument for input filename.
        File inputFile = new File("/Users/arjunprabhune/School_Idea_Projects/CodioClasses/src/puzzle.txt");
        Scanner finput = new Scanner(inputFile);

        int matrixSize = finput.nextInt();
        matrix = new char [matrixSize][matrixSize];
        output = new char [matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = finput.next().charAt(0);
                System.out.print(matrix[i][j] + " ");
                output[i][j] = ' ';
            }
            System.out.println();
        }

        //read the words and find them in matrix!
        int numWords = finput.nextInt();
        for (int i = 0; i < numWords; i++) {
            String word = finput.next();
            System.out.println(word);
            findWord(word);
        }

        //output the words in matrix format
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++)
                System.out.print(output[i][j] + " ");
            System.out.println();
        }



    }
}
