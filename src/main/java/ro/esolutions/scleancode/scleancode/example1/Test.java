package ro.esolutions.scleancode.scleancode.example1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        String givenWord = "2jjjj79dcdcdc9";
        ArrayList<String> words = findNonDigitSequenceOfChar(givenWord, 1);


        for (String Word : words) {
            System.out.println(Word);
        }
    }

    private static ArrayList<String> findNonDigitSequenceOfChar(String givenWord, int minimumSize) {
        assert (givenWord != null) : "Given Word is null";
        assert (givenWord.length() != 0) : "Given Word has zero character";
        assert (minimumSize >= 0) : "negative size number";

        ArrayList<String> nonDigitSequences = new ArrayList<>();
        int minimumWordSizetoFindaSubString = minimumSize + 3;

        if (noSubArrayFound(givenWord, minimumWordSizetoFindaSubString)) {
            System.out.print("no sub array found");
            return nonDigitSequences;
        }

        boolean isFirstNumberFound = false;
        int firstNumberPlace = 0;
        final int startingPoint = 0;
        final int endingPoint = givenWord.length();

        for (int stringIndex = startingPoint; stringIndex < endingPoint; stringIndex++) {
            char charread = givenWord.charAt(stringIndex);
            if (!isNumeric(charread)) {
                continue;
            }
            if (isFirstNumberFound == false) {
                isFirstNumberFound = true;
                firstNumberPlace = stringIndex;
            } else {
                char leftcharacter = givenWord.charAt(firstNumberPlace);
                char rightcharacter = givenWord.charAt(stringIndex);

                if (CompareDigits(leftcharacter, rightcharacter)) {

                    String foundString = CopyString(givenWord, firstNumberPlace,
                            stringIndex);

                    if (foundString.length() > minimumSize) {
                        nonDigitSequences.add(foundString);
                    }

                }
                firstNumberPlace = stringIndex;
            }

        }

        assert (nonDigitSequences != null) : "Null SubString Returned";


        return nonDigitSequences;
    }

    private static boolean noSubArrayFound(String givenWord, int minimumWordSizetoFindaSubString) {
        return givenWord.length() < minimumWordSizetoFindaSubString;
    }


    private static boolean isNumeric(Character givencharacter) {
        assert (givencharacter != null) : " NULL character error";

        if (Character.isDigit(givencharacter)) {
            return true;

        } else {
            return false;
        }

    }


    private static boolean CompareDigits(char leftcharacter, char rightcharacter) {

        if (leftcharacter >= rightcharacter) {
            return false;
        } else {
            return true;
        }

    }


    private static String CopyString(String given, int leftplace, int rightplace) {
        assert (given != null) : " NULL String error";

        String Copied = "";

        for (int k = leftplace + 1; k < rightplace; k++) {
            Copied = Copied + given.charAt(k);
        }


        assert (Copied != null) : " NULL Word Found returned";

        return Copied;
    }
}
