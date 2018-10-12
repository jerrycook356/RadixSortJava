
public class RadixSortMain {

	public static void main(String[] args) {

		int[] radixArray = {4725,4586,1330,8792,1594,5729};
		
		radixSort(radixArray,10,4);
		print(radixArray);
	}
	
	
	public static void radixSort(int[] radixArray, int radix, int width) {
		for(int i = 0 ;i < width;i++)
		{
			radixSingleSort(radixArray, i, radix);
		}
	}
	
	public static void radixSingleSort(int[] radixArray,int position, int radix) {
		
		int numItems = radixArray.length;
		int[] countArray = new int[radix];
		
		//count of how many values have a specific digit at the position
		for(int value: radixArray) {
			countArray[getDigit(position,value,radix)]++;
		}
		
		//adjust the count array now contains the values that have that digit
		//or less at the position we are working.
		for(int j = 1;j < radix;j++) {
			countArray[j]+=countArray[j-1];
		}
		
		//copy values into temp array right to left to preserve order
		int[] temp = new int[numItems];
		for(int tempIndex = numItems -1; tempIndex >=0; tempIndex--) {
			temp[--countArray[getDigit(position,radixArray[tempIndex],radix)]] = radixArray[tempIndex];
		}
		
		//copy tempArray back to original array
		for(int tempIndex = 0;tempIndex < numItems;tempIndex++)
		{
			radixArray[tempIndex] = temp[tempIndex];
		}
		
		
	}
	public static void print(int[] radixArray) {
		for(int i = 0; i < radixArray.length;i++) {
			System.out.println(radixArray[i]);
		}
	}
	
	public static int getDigit(int position, int value, int radix) {
		return value /(int) Math.pow(radix, position)% radix;
	}

}
