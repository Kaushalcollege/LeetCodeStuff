class Solution {
    public int[] sortArray(int[] nums) {
      ms(nums, 0, nums.length - 1);
      return nums;
    }

    void ms(int arr[], int low, int high) {
    if (low == high)
      return;

    int mid = (low + high) / 2;
    ms(arr, low, mid);
    ms(arr, mid + 1, high);
    merge(arr, low, high, mid);

  }

  void merge(int arr[],int low,int high,int mid)
  {
    int left[] = new int[mid - low + 1];
    int right[] = new int[high - mid];

    int p = 0;
    for (int i = low; i <= mid ; i++) {
      left[p] = arr[i];
      p++; 
    }
    p = 0;
    for (int i = mid + 1; i <= high; i++) {
      right[p] = arr[i];
      p++;
    }
    
    int k = low;
    int i = 0, j=0;
    
    while (i < (mid - low + 1) && j < (high - mid)) {

      if (left[i] < right[j]) {
        arr[k] = left[i];
        k++;
        i++;
      } else {
        arr[k] = right[j];
        k++;
        j++;
      }
    }
    
    while (i < (mid - low + 1)) {
      arr[k] = left[i];
      k++;
      i++;
    }
    while (j < (high - mid)) {
      arr[k] = right[j];
      k++;
      j++;
    }

  }
  
}

