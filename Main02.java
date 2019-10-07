package CodingInterview;

import java.util.Scanner;

// 100 %
public class Main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String input = scan.nextLine();
            System.out.println(reverseSentence(input.toCharArray()));
        }

    }

    private static String reverseWord(char[] word){
        int i = 0, j = word.length-1;
        char temp = ' ';
        while (i < j){
            temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        String res = "";
        int k = 0;
        while (k < word.length){
            if(word[k]!='*' && word[k]!='@'){
                res += word[k];
            }
            k++;
        }
        return res;
    }

    private static String reverseSentence(char[] sentence){
        String reverseSen = reverseWord(sentence);
        reverseSen = reverseSen.replaceAll(" -"," ");
        reverseSen = reverseSen.replaceAll("- "," ");
        reverseSen = reverseSen.replaceAll("--"," ");
        reverseSen = reverseSen.replaceAll("( )+"," ");
        String[] words = reverseSen.split(" ");
        String res = "";
        for (int i=0;i<words.length;i++){
            res += reverseWord(words[i].toCharArray());
            res += " ";
        }
        return res.substring(0,res.length()-1);
    }
}