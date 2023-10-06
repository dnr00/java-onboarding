package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = " ";

         {
            cryptogram.replaceAll(".{2}", "");
        }

        answer = cryptogram;
        String result = answer;

        return result;
    }
}

    // if(cryptogram.length() >= 1 && cryptogram.length() <= 1000) //필요한가?