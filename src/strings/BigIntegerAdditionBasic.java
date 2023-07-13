package strings;

import java.util.*;

class BigIntegerAdditionBasic {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();

        String ans = bigIntegerAddition(num1, num2);
        System.out.println(ans);

    }

    // TODO: Implement this method
    static String bigIntegerAddition(String num1, String num2) {
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        s1.reverse();
        s2.reverse();
        int carry = 0;
        int i =0,j=0;
        boolean first = false;
        if(s1.length()>=s2.length()) {
        	first = true;
        }
        while(i<s1.length() && j<s2.length()) {
        	int sum = (s1.charAt(i)-'0') + (s2.charAt(j)-'0') + carry;
        	carry = sum/10;
        	sum = sum%10;
        	if(first) {
        		s1.setCharAt(i, (char)(sum+'0'));
        	}
        	else {
        		s2.setCharAt(j, (char)(sum+'0'));
        	}
        	i++;
        	j++;
        }
        while(i<s1.length()) {
        	int sum = (s1.charAt(i)-'0')+ carry;
        	carry = sum/10;
        	sum = sum%10;
        	s1.setCharAt(i, (char)(sum+'0'));
        	i++;
        }
        while(j<s2.length()) {
        	int sum = (s2.charAt(j)-'0') + carry;
        	carry = sum/10;
        	sum = sum%10;
        	s2.setCharAt(j, (char)(sum+'0'));
        	j++;
        }
        if(carry!=0) {
        	if(first) {
        		s1.append(carry);
        	}
        	else {
        		s2.append(carry);
        	}
        }
        s1.reverse();
        s2.reverse();
        String ans;
        if(first) {
        	ans = new String(s1);
        }
        else {
        	ans = new String(s2);
        }
        return ans;
    }
}

/* 
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output

Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving and see if you can recollect solving similar problems in the past
      a. Obvious logic (this would only test ability to convert logic to code)
      b. Figuring out logic
      c. Knowledge of specific algorithm, data structure or pattern
      d. Knowledge of specific domain or concepts
      e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one based on the TC/SC requirements
3. Get to a point where you can explain your approach to a 10 year old

Milestone 3 : Come up with an “Instruction Manual” for a 10 year old
1. Take a stab at the high-level logic & write it down like a detailed Instruction Manual for a 10 Year old where each line of the manual can be expanded into a logical line(s) of code.
2. Try to offload logic out of the main section as much as possible by delegating to functions.

Milestone 4: Code by expanding your 10 Year Old’s "Instruction Manual”
1. Run your code snippets at every logical step to test correctness (Helps avoid debugging larger pieces of code later)
2. Make sure you name the variables, functions clearly.
3. Use libraries as much as possible

Milestone 5: Prove that your code works using custom test cases
1. Make sure you check boundary conditions and other test cases you noted in Milestone 1
      a. If compiler is not available, dry run your code on a whiteboard or paper
2. Suggest optimizations if applicable during interviews
*/