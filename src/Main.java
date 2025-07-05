import java.util.*;

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

        //answer to this testcase: 2 --> sum can only come from both arrays, not just one
        //1+4 = 5
        //secondary = {1,5}
        //1+3 = 4
        //result = 2
        int prob4 = problem4(primary, secondary, operations);

        System.out.println(prob2);
        System.out.println(prob3);
        System.out.println(prob4);
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

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            //want to keep adding words to row until there is no more space in row, determined by length
            //do an initial loop (without adding to the row yet) to see how many words I can fit
            //the length of the current word + length of the next word + (num of words - 1), rather than just adding 1 space
            //have to dynamically add spaces for each word that is iterated through, j - i accumulates
            while (j < words.length && lineLength + words[j].length() + (j - i) <= innerLength) {
                lineLength += words[j].length();
                j++;
            }
            //when out of loop, have max amount of words that can fit in row
            //now add to row, goes from i to j-1 because that is the span of words that fit in the current row
            //using a list of strings to hold the words is a lot easier to work with when adjusting for spaces
            List<String> lineWords= new LinkedList<>();
            for (int k = i; k < j; k++) {
                lineWords.add(words[k]);
            }

            //now have to adjust for spaces
            //need different logic when it is the last line
            //takes row, length it needs to be, and whether it is the last line
            //j is the index of the first word that does not fit on the current line!
            String line = adjustForSpaces(lineWords, innerLength, j == words.length);
            //add asterisk at beginning and end
            result.add("*" + line + "*");

            //moves counter along!
            i = j;
        }

        //Add border
        String border = "*".repeat(width);
        result.addFirst(border);
        result.add(border);

        return result;
    }

    //passing in a list of strings allows for easy space concatenation
    private static String adjustForSpaces(List<String> list, int innerLength, boolean b) {
        int totalLen = 0;

        if (list.size() == 1 || b) {
            String line = String.join(" ", list);
            return line + " ".repeat(innerLength - line.length());
        }

        //iterate through list
        //add up the length of all the words on the list
        for (String w : list) {
            totalLen += w.length();
        }

        //subtract from innerLength
        //divide remainder by number of words
        int spaceCount = innerLength - totalLen;
        //the amount of words - 1 because that is the count of the space placement between the words
        //need to account for even space and extra space
        int gaps = spaceCount / (list.size()-1);
        int extraSpace = spaceCount % (list.size()-1);

        //add after each word
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
            //need to disperse extra space evenly
            if (i < list.size()-1) {
                int space = gaps;
                if (i < extraSpace) {
                    space += 1;
                }
                answer.append(" ".repeat(space));
            }
        }

        return answer.toString();
    }

    //3 arrays operations
    public static int problem4(int[] primary, int[] secondary, int[][] operations) {
        int result = 0;

        //iterate through operation
        //first branching: if operations is 0 or 1
        for (int[] op : operations) {
            //if 0, replace value of secondary at index
            if (op[0] == 0) {
                secondary[op[1]] = op[2];
            }
            //if 1, check for sum of ints from both arrays
            else if (op[0] == 1) {
                result += countOfSumOfInts(op[1], primary, secondary);
            }
        }

        return result;
    }

    private static int countOfSumOfInts(int target, int[] primary, int[] secondary) {
        //create hashset to hold all values from priamry and secondary
        int result = 0;
        Map<Integer, Integer> sec = new HashMap<>();

        for (int num : secondary) {
            sec.put(num, sec.getOrDefault(num, 0) + 1);
        }

        //check for what 2 numbers == op[1]
        for (int num : primary) {
            int complement = target - num;
            //increment result when known
            if (sec.getOrDefault(complement, 0) != 0) {
                result += sec.get(complement);
            }
        }

        return result;
    }

}
