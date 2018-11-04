package desire.morse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {

    static MorseCodeTree<String> tree = new MorseCodeTree<>();

    public static String printTree() {
        String result="";
        for(String s: tree.toArrayList()){
            result += s+" ";
            System.out.println("Current value ::: "+s );
        }
        return result;
    }

    public static String convertToEnglish(String s) {
        Scanner sc = new Scanner(s);
        String letter="";
        String result = "";

        while(sc.hasNext())
        {
            letter = sc.next();
            if(letter.equals("/"))
            {
                result +=" ";
            }
            else
            {
                result +=  tree.fetch(letter);
            }
        }
        sc.close();
        return result;
    }

    public static String convertToEnglish(File inputFile) {
        String result = "";
        String letter;
        try
        {
            if(inputFile==null)
            {
                throw new FileNotFoundException();
            }
            Scanner sc = new Scanner(inputFile);

            while(sc.hasNext())
            {
                letter = sc.next();
                if(letter.equals("/"))
                {
                    result +=" ";
                }
                else
                {
                    result +=  tree.fetch(letter);
                }

            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
        return result;
    }
}
