package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
 public static void main(String[] args) {
      Stack<Integer> mtnStack = new Stack<Integer>();
      Stack<Integer> branchStack = new Stack<Integer>();
      ArrayList<Boolean> results = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int tests = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < tests; i++) //For every test 
    {
      int cars = Integer.parseInt(sc.nextLine()); //Get the amount of cars
      for (int j = 0; j < cars; j++) { //Build the stack
    	 //System.out.println("Line " + Integer.toString(j));
        mtnStack.push(Integer.parseInt(sc.nextLine()));
      }
      boolean result = true;
      int k = 1;
          while (true)
          {
        	//Check the mountain
            if (safePeek(mtnStack) == k)
            {
              mtnStack.pop();
              k++;
              continue;
            }
            //Check the branch
            if (safePeek(branchStack) == k)
            {
              branchStack.pop();
              k++;
              continue;
            }
            //Check if the mountain doesn't have it and isn't empty
            if (safePeek(mtnStack) != k && !mtnStack.isEmpty())
            {
              branchStack.push(mtnStack.pop()); //pop to the branch
              continue;
            }
            //check if the mountain and branch are both empty 
            if (mtnStack.isEmpty() && branchStack.isEmpty())
            {
              result = true;
              break;
            }
            //check if both the branch and mountain don't have it
            if (safePeek(mtnStack) != k && safePeek(branchStack) != k && (!mtnStack.isEmpty() || !branchStack.isEmpty()))
            {
            	result = false;
            	break;
            }
          }
          System.out.println("Completed processing");
          results.add(result);
          mtnStack.clear();
          branchStack.clear();
          
    }
    for (boolean bool : results)
    {
      System.out.println(bool ? "Y" : "N");
    }
 }

static int safePeek(Stack<Integer> stack) //Helper function to make sure peek() doesn't throw an exception.
 {
  if(stack.empty())
  {
	  return 0;
  }else {
	  return stack.peek();
  }
 }
}