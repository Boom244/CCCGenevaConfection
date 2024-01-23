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
				mtnStack.push(Integer.parseInt(sc.nextLine()));
			}
			//Analyze the stack
			for (int k = 1; k < cars+1; k++)
			{
				if (!mtnStack.empty())
				{
					if (mtnStack.firstElement() == k)
					{
						mtnStack.pop();
					}
				}
			}
			results.add(verifyNumericalOrder(branchStack,k));
			branchStack.clear();
			mtnStack.clear();
		}
		for (boolean bool : results)
		{
			System.out.println(bool ? "Y" : "N");
		}
 }
 
static boolean verifyNumericalOrder(Stack<Integer> stack, int next)
 {
	int startNum = next;
	while (!stack.empty())
	{
		if (stack.peek() == startNum)
		{
			startNum++;
			stack.pop();
		}else {
			return false;
		}
	}
	return true;
 }
}