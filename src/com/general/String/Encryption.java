package com.general.String;

/**
 * Created by dhanetwa on 7/28/2018.
 */
public class Encryption {
//abcde - > encryption to eeeee -- means add size of string int to to 1st char and then decrement. a- 4, b-3.. and then add these values to char. a will become e.

    public String getEncryptedString(String phrase) {
        String words[] = phrase.split(" ");
        StringBuilder modifiedString = new StringBuilder();
        for (String word : words) {
            char charArr[] = word.toCharArray();
            int count = charArr.length - 1;
            for (int i = 0; i < charArr.length; i++) {
                int charAscii = 0;
                if (charArr[i] + count > 122) {
                    charAscii = charArr[i] + count - 26;
                } else {
                    charAscii = charArr[i] + count;
                }
                charArr[i] = (char) (charAscii);
                count--;
            }
            modifiedString.append(charArr).append(" ");
        }
        return modifiedString.toString().trim();
    }

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        System.out.println(encryption.getEncryptedString("abcde"));
        System.out.println(encryption.getEncryptedString("vywza xyzab"));
    }
}
