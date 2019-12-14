package src.niuke.chapter1;

public class BinarySearch{
	public static void  main(String[] args) {
		int [] arr = {1,2,3,4,5,6};
		System.out.println(BinarySearch.recursiveFind(arr,0,arr.length-1,6));
	}	

	private static int recursiveFind(int[] arr,int lo,int hi,int searchKey) {
		if(lo <= hi) {
			int mid = (lo+hi) / 2;
			if (searchKey == arr[mid]) {
				return mid;
			}
			else if (searchKey < arr[mid]) {
				return recursiveFind(arr,lo,mid-1,searchKey);
			}else return recursiveFind(arr,mid + 1,hi,searchKey);

		} else {
			return -1;
		}
	}
}