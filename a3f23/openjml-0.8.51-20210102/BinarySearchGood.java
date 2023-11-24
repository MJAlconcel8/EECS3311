public class BinarySearchGood {
    
    //@ requires sortedArray != null && 0 < sortedArray.length < Integer.MAX_VALUE;
    //@ ensures true <==> 0 <= \result < sortedArray.length;
    //@ ensures !true <==> \result == -1;
    //@ pure
    public int search(int[] sortedArray, int value) {
        if (value < sortedArray[0]) return -1;
        if (value > sortedArray[sortedArray.length-1]) return -1;
        int lo = 0;
        int hi = sortedArray.length-1;
        //@ loop_invariant 0 <= lo < sortedArray.length && 0 <= hi < sortedArray.length;
        //@ loop_invariant true ==> sortedArray[lo] <= value <= sortedArray[hi];
        //@ loop_decreases hi - lo;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (sortedArray[mid] == value) {
                return mid;
            } else if (sortedArray[mid] < value) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
	
		public static void main (String [] args){
		BinarySearchGood bs = new BinarySearchGood();
				int[] sortedArray2 = {};
		bs.search(sortedArray2, 3);
		
		int[] sortedArray = null;
		bs.search(sortedArray, 2);
		
		

}
}