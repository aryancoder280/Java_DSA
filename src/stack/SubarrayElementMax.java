package stack;

import java.util.*;


class SubarrayElementMax{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int siz = sc.nextInt();
        int[] array = new int[siz];
        for (int i = 0; i < siz; ++i) {
            array[i] = sc.nextInt();
        }
        sc.close();
        int[] list_of_output = subarrayElementMax(siz,array);
        for(int i=0;i<siz;i++){
            System.out.print(list_of_output[i]+" ");
        }
    }
    static void nextGreater(int i,Stack<Integer>stack,int arr[],int res[],boolean fromEnd) {

        if(fromEnd) {
            for(;i>=0;i--) {
                int val = arr[i];
                if(stack.isEmpty()) {
                    stack.push(i);
                    res[i] = arr.length;
                }
                else {
                    int ind = stack.peek();
                    if(arr[ind]<=val) {
                        while(!stack.isEmpty() && arr[stack.peek()]<=val) {
                            stack.pop();
                        }
                        if(stack.isEmpty()) {
                            res[i] = arr.length;
                        }
                        else {
                            res[i] = stack.peek();
                        }
                    }
                    else {
                        res[i] = ind;
                    }
                    stack.push(i);
                }
            }
        }
        else {
            for(;i<arr.length;i++) {
            	int val = arr[i];
            	if(stack.isEmpty()) {
            		res[i] = -1;
            		stack.push(i);
            	}
            	else {
            		int ind = stack.peek();
            		if(arr[ind]<=val) {
            			 while(!stack.isEmpty() && arr[stack.peek()]<=val) {
                             stack.pop();
                         }
                         if(stack.isEmpty()) {
                             res[i] = -1;
                         }
                         else {
                             res[i] = stack.peek();
                         }
            		}
            		else {
            			res[i] = ind;
            		}
            		stack.push(i);
            	}
            }
        }
    }
    static int[] subarrayElementMax(int siz,int[] arr){
        Stack<Integer>stack = new Stack<Integer>();
        int right[] = new int[siz];
        int left[] = new int[siz];
        int ans[] = new int[siz];
        Arrays.fill(right,0);
        Arrays.fill(left,0);
        boolean fromEnd = true;
        nextGreater(siz-1,stack,arr,right,fromEnd);
        stack.clear();
        fromEnd = !fromEnd;
        nextGreater(0,stack,arr,left,fromEnd);
//        for(int i=0;i<siz;i++) System.out.print(right[i] + " ");
//        System.out.println();
//        for(int i=0;i<siz;i++) System.out.print(left[i] + " ");
//        System.out.println();
        
        for(int i=0;i<siz;i++) {
        	ans[i] = (right[i]-i) + (i-left[i]) - 1;
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

Milestone 3 : Come up with an Instruction Manual for a 10 year old
1. Take a stab at the high-level logic & write it down like a detailed Instruction Manual for a 10 Year old where each line of the manual can be expanded into a logical line(s) of code.
2. Try to offload logic out of the main section as much as possible by delegating to functions.

Milestone 4: Code by expanding your 10 Year Olds "Instruction Manual
1. Run your code snippets at every logical step to test correctness (Helps avoid debugging larger pieces of code later)
2. Make sure you name the variables, functions clearly.
3. Use libraries as much as possible

Milestone 5: Prove that your code works using custom test cases
1. Make sure you check boundary conditions and other test cases you noted in Milestone 1
      a. If compiler is not available, dry run your code on a whiteboard or paper
2. Suggest optimizations if applicable during interviews
*/