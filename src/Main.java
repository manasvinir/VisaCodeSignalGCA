import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
    }



    //adding value of 2 strings
    public static String problem2(String a, String b) {
        StringBuilder result = new StringBuilder();

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