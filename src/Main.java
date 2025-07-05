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

        System.out.println(prob3);
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
        int innerLength = width - 2;
        int i = 0; //counter

        //iterate through words in array --> while loop condition
        //add to string
        //keep track of length of string, has to remain below length
        //at the end of each string, need to append asterisk

        //switch from for loop to while loop
        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            //want to keep adding words to row until there is no more space in row, determined by length
            //do an initial loop (without adding to the row yet) to see how many words I can fit
            while (j < words.length && lineLength + 1 + words[j].length() <= innerLength) {
                lineLength += words[j].length();
                j++;
            }
            //when out of loop, have max amount of words that can fit in row
            //now add to row, goes from i to j because that is the span of words that fit in the current row
            StringBuilder row = new StringBuilder();
            for (int k = i; k < j; k++) {
                row.append(words[k]);
            }

            //now have to adjust for spaces
            //need different logic when it is the last line
            //created another function to hold adjustment logic
            //takes row, length it needs to be, and whether it is the last line
            //j is the index of the first word that does not fit on the current line!
            String line = adjustForSpaces(row, innerLength, j == words.length);
            //add asterisk at beginning and end
            result.add("*" + line + "*");

            //moves counter along!
            i = j;
        }

        //Add border


        return result;
    }

    private static String adjustForSpaces(StringBuilder row, int innerLength, boolean b) {
        return row.toString();
    }

    //3 arrays operations
    public static int[] problem4(int[] primary, int[] secondary, int[][] operations) {
        int[] answer = new int[5];

        return answer;
    }

}


/*

for (int i = 0; i < words.length; i++) {
            if (row.length() <= length) {
                if (words[i].length() < length - words[i].length()) {
                    row.append(words[i]);
                    if (words[i].length() + 1 < length - (words[i].length() + 1)) {
                        row.append(" ");
                    }
                }

//                //check if next word is able to be in row, if not then need to respace row
//                if (words[i].length() < length - words[i].length()) {
//                    row.append(words[i]);
//                    if (words[i].length() + 1 < length - (words[i].length() + 1)) {
//                        row.append(" ");
//                    }
//                }

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

                //clears row
                row.setLength(0);
                //add spaces between each word
                String space = " ";
                for (String w : currRow) {
                    w += space.repeat(spaceCount);
                    row.append(w);
                }

                //with integer division, check if there is any leftover spaces to be added
                while (length - row.length() != 0) {
                    row.append(" ");
                }
            }
            //add asterisk
            row.insert(0, "*");
            row.insert(row.length()-1, "*");

            result.add(row.toString());
        }
        String asterisk = "*";
        result.addFirst(asterisk.repeat(width));
        result.addLast(asterisk.repeat(width));
 */