import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //answer to testcase should be 1115
        String prob2 = problem2("72", "143");

        List<String> prob3 = problem3(new String[] {"I", "am", "deeply", "excited", "about", "potentially", "moving",
                                                    "forward", "in", "Visa's", "interview", "process!"}, 20);

        int[] primary = {1, 2, 3};
        int[] secondary = {4, 5};
        int[][] operations = {
                {1, 5},
                {0, 0, 1},
                {1, 4}
        };

        int[] prob4 = problem4(primary, secondary, operations);

        System.out.println(prob2);
    }



    //adding value of 2 strings
    public static String problem2(String a, String b) {
        StringBuilder result = new StringBuilder();

        //I was not iterating and appending through the strings properly in my initial case
        //need to find the string that is longer
        int lenA = a.length();
        int lenB = b.length();
        int maxLength = Math.max(lenA, lenB);

        //rather than finding the specific string that is shorter and padding it with 0s,
        //can just do it for both and make sure logic excludes the longer string (faster)
        //was blanking on how to do this easily
        StringBuilder aBuilder = new StringBuilder(a);
        StringBuilder bBuilder = new StringBuilder(b);

        //first attempt, while loop was not working right, need to split appending of strings
        while(a.length() < maxLength) {
            a = "0" + a;
        }
        while (b.length() < maxLength) {
            b = "0" + b;
        }
        System.out.println(a);
        System.out.println(b);

        //iterate through loop in reverse
        //take char at pos i, convert into ints, add together, convert into string, append to result
        for (int i = maxLength-1; i >= 0; i--) {
            int valA = a.charAt(i) - '0';
            int valB = b.charAt(i) - '0';
            int sum = valA + valB;
            //stringbuilder directly accepts primitive types, do not need to explicitly convert!
            result.insert(0, sum);
        }

        return result.toString();
    }

    //adjusting paragraph formatting with width
    public static List<String> problem3(String[] words, int width) {
        List<String> result = new LinkedList<>();

        return result;

    }

    //3 arrays operations
    public static int[] problem4(int[] primary, int[] secondary, int[][] operations) {
        int[] answer = new int[5];

        return answer;
    }

}