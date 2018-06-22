
package assignment.weight_watchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ProblemThree {

	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public void generateRandomNumbers(int n) {
		
		Random random = new Random();
		for(int i=0;i<n;i++) {
			numbers.add(random.nextInt(500));
		}
	}
	
	private int getNthMin (int n) {
		if(n <=0 || n> numbers.size()) {
			throw new ArrayIndexOutOfBoundsException("Maximum of array is "+ numbers.size());
		}
		return numbers.get(n-1);
		
	}
	public static void main(String[] args) {
		
		ProblemThree findMinimum = new ProblemThree();
		findMinimum.generateRandomNumbers(500);
		Collections.sort(findMinimum.numbers);
		
		System.out.println(findMinimum.getNthMin(5));
		System.out.println(findMinimum.getNthMin(50));
		System.out.println(findMinimum.getNthMin(5));
	}
	
	
	
	
}
