import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class binarysearch {

    public static void main(String[] args)  throws IOException,FileNotFoundException {
        Scanner currentScan = new Scanner(new File("C:\\Users\\musta\\Desktop\\oliver.txt"));          //Reading the oliver file using scanner
        String [] dictionary = dictionaryList();
        int incorrectWords = 0;
        int correctWords = 0;
        long startTime = System.currentTimeMillis();                    //Start time

        while (currentScan.hasNext()) {                                //Using a while loop to Find the current word
            String currentWord = remove(currentScan.next());                     //Assigning current word
            int result = binarySearch(dictionary, currentWord);             //Binary search method
            if (result == -1) {                                                 //Count incorrect words

                incorrectWords++;

                                            //Uncomment to see elements not present | System.out.println("Element not present: " + currentWord);
            }
             else
                 correctWords++;                                            //Count correct words

        }
        long endTime = System.currentTimeMillis();                      //End time
        float totalTime = endTime - startTime;                          //Total time
        int total = incorrectWords + correctWords;                      //Total of correct and incorrect in text
        System.out.println("Time: " + totalTime/1000 + " seconds");        //Print out values
        System.out.println("Number found in dictionary: "+ correctWords);
        System.out.println("Number not found in dictionary: "+ incorrectWords);
        System.out.println("Total number of words in text: "+ total);

   }


    public static String[] dictionaryList() throws FileNotFoundException{               //Dictionary list method
        Scanner arrayScan = new Scanner(new File("C:\\Users\\musta\\Desktop\\dictionary.txt"));        //Scan the array
        String[] dictionary = new String[235886];                                                           //Array size set
        while(arrayScan.hasNext()) {                                        //While loop to scan each word


            for (int i = 0; i < dictionary.length; i++) {                   //Going through the array index
                String input = arrayScan.nextLine();                        //Assign input to each String word
                dictionary[i] = input;                                      //Assign each index to the input
            }
        }
            return dictionary;                                              //Return dictionary
    }


    public static String remove(String symb){                           //Removing symbols
        symb = symb.replaceAll("/", "").trim();
        symb = symb.replaceAll("'", "");
        symb = symb.replaceAll(" ", "");

        symb = symb.replaceAll("[^a-zA-Z\\s]", "");

        return symb;
    }







  public static int binarySearch(String[] dictionary, String currentWord){           //Create Binary search method with String array of dictionary and String current word

        int l = 0, r = dictionary.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = currentWord.compareToIgnoreCase(dictionary[m]);

            // Check if currentWord is present at mid
            if (res == 0)
                return m;

            // If currentWord greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If currentWord is smaller, ignore right half
            else
                r = m - 1;
        }
        return -1;


    }

}