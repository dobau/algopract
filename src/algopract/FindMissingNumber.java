package algopract;

import java.util.stream.IntStream;

public class FindMissingNumber {

	public static void main(String[] args) {
		int total = 6;
		int[] numbers = createNumbersArray(total, 5);
		
		System.out.println(solution1(numbers, total));
		System.out.println(solution2(numbers, total));
	}

	private static int solution1(int[] arr, int total) {
		for (int i = 1; i <= total; i++) {
			if (total < i || arr[i - 1] != i) {
				return i;
			}
		}
		
		return -1;
	}

	private static int solution2(int[] numbers, int total) {
		int expectedSum = (int) (total * ((float)(total + 1) / 2));
		int actualSum = 0;
		
		for (int n : numbers) {
			actualSum += n;
		}
		
		return expectedSum - actualSum;
	}
	
	public static int[] createNumbersArray(int end, int missingNumber) {
		return IntStream.rangeClosed(1, end).filter(n -> n != missingNumber).toArray();
	}
	
}
