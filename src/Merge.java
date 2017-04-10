
import java.util.Arrays;
public class Merge{
  
  public static void main(String[] args){
    long start = System.nanoTime();
    int[] arr = {3,23,4,2,1,34,3,2,34,4,3,5,35,4,6,46,43,64,4,542,3,42};
    arr=merge_sort(arr);
    long stop = System.nanoTime();
    System.out.println(Arrays.toString(arr));
    System.out.println("Runtime was: " + (stop-start));
  }
  
  public static void changeIndex(int[] arr){
    arr[0]=5;
  }
  
  public static int[] merge_sort(int[] arr){
    
    int left = 0;
    int right = arr.length-1;
    int mid = (right+left)/2+1;
    int[] sortedArr = arr;
    if(right>left){
      int[] leftArr = Arrays.copyOfRange(arr,left,mid);
      int[] rightArr = Arrays.copyOfRange(arr,mid,right+1);
      int[] sortedLeftArr = merge_sort(leftArr);
      int[] sortedRightArr = merge_sort(rightArr);
      sortedArr = merge(sortedLeftArr,sortedRightArr);
    }
    return sortedArr;
  }
  
  public static int[] merge(int[] leftArr, int[] rightArr){
    int[] temp = new int[leftArr.length+rightArr.length];
    int i=0,j=0,k=0;
    //i is beginning of leftArr, j is beginning of rightArr, and k is index in temp
    
    while(i<leftArr.length && j<rightArr.length){
      if(leftArr[i]<=rightArr[j]){
        temp[k]=leftArr[i];
        k++;
        i++;
      }
      else{
        temp[k]=rightArr[j];
        k++;
        j++;
    }
    }
    if(i==leftArr.length){
      for(int index=j;index<rightArr.length;index++){
        temp[k]=rightArr[index];
        k++;
      }
    }
    else{
      for(int index=i;index<leftArr.length;index++){
        temp[k]=leftArr[index];
        k++;
      }
    }
    return temp;
  }
  
}
