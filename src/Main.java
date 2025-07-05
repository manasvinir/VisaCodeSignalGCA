import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //answer to testcase should be 1115
        String prob2 = problem2("72", "143");

        /* answer to testcase:
        [
            "********************",
            "*I   am   deeply   *",
            "*excited    about  *",
            "*potentially moving*",
            "*forward in Visa's *",
            "*interview process!*",
            "********************"
        ]
         */
        List<String> prob3 = problem3(new String[] {"I", "am", "deeply", "excited", "about", "potentially", "moving",
                                                    "forward", "in", "Visa's", "interview", "process!"}, 20);

        int[] primary = {1, 2, 3};
        int[] secondary = {4, 5};
        int[][] operations = {
                {1, 5},
                {0, 0, 1},
                {1, 4}
        };

        //answer to this testcase:
        int[] prob4 = problem4(primary, secondary, operations);

//        System.out.println(prob2);
    }



    //adding value of 2 strings
    public static String problem2(String a, String b) {
        StringBuilder result = new StringBuilder();

        //I was not iterating and appending through the strings properly in my initial case
        //need to find the string that is longer
        int maxLength = Math.max(a.length(), b.length());

        //rather than finding the specific string that is shorter and padding it with 0s,
        //can just do it for both and make sure logic excludes the longer string (faster)
        //was blanking on how to do this easily

        //first attempt, while loop was not working right, need to split appending of strings
        while(a.length() < maxLength) {
            a = "0" + a;
        }
        while (b.length() < maxLength) {
            b = "0" + b;
        }
//        System.out.println(a);
//        System.out.println(b);

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
        //need to ensure that the length of each row is the width passed in
        //need to accommodate for asterisk placement as well
        List<String> result = new LinkedList<>();
        StringBuilder row = new StringBuilder();
        int length = width - 2;

        //iterate through words in array
        //add to string
        //keep track of length of string, has to remain below length
        //at the end of each string, need to append asterisk
        for (int i = 1; i < words.length; i++) {
            if (row.length() <= length) {
                if (words[i - 1].length() < length - words[i - 1].length()) {
                    row.append(words[i - 1]);
                    if (words[i - 1].length() + 1 < length - (words[i - 1].length() + 1)) {
                        row.append(" ");
                    }
                }

                //check if next word is able to be in row, if not then need to respace row
                if (words[i].length() < length - words[i].length()) {
                    row.append(words[i]);
                    if (words[i].length() + 1 < length - (words[i].length() + 1)) {
                        row.append(" ");
                    }
                } else {
                    int currLen = row.length();
                    //count how many words and the length of each of those words in current row
                    //subtract value from length to get spaceCount
                    //divide spaceCount by numOfWords to see how many spaces are to be added after each word
                    String text = row.toString();
                    String[] currRow = text.split("\\s+");
                    String noWhitespaceString = row.toString().replaceAll("\\s", "");
                    int spaceCount = length - noWhitespaceString.length();
                    spaceCount /= currRow.length;




                }


            }


            //add asterisk
        }

        return result;

    }

    //3 arrays operations
    public static int[] problem4(int[] primary, int[] secondary, int[][] operations) {
        int[] answer = new int[5];

        return answer;
    }

}