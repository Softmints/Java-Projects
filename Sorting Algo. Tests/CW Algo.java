import java.util.Arrays;

class Sorting{

public static void main(String[] args) {

	int[] testArray = bubbleArray();

	System.out.println(Arrays.toString(testArray));

}


	public static int[] bubbleArray(){

		int[] testArray = {8,15,13,72,4,58,39,91,12,36,47};
		int arraySize = testArray.length;

		for(int i = arraySize - 1; i > 1; i--){

			for(int j = 0; j < i; j++){

				if(testArray[j] > testArray[j+1]){

					int temp = testArray[j+1];
					testArray[j+1] = testArray[j];
					testArray[j] = temp;
				}
			}
		}

		return testArray;

	}

}




