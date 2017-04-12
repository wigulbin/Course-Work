
public class mergesort {

	private static int[] array;
	private static int[] tempMergArr;
	private static int length;

	public static void main(String args[]){
		int[] inputArr = {5,7,2,18,1,10,8,6};

		sort(inputArr);
		System.out.println(inputArr);
	}

	public static void sort(int inputArr[]){
		array = inputArr;
		length = inputArr.length;
		tempMergArr= new int[length];
		merge(0, length - 1);
	}

	private static void merge(int LIndex, int HIndex){
		if (LIndex < HIndex){
			int middle = LIndex + (HIndex - LIndex)/2;
			merge(LIndex, middle);
			merge(middle+1,HIndex);
			mergeParts(LIndex,middle,HIndex);
		}	
	}
	private static void mergeParts(int LIndex, int middle, int HIndex){
		for(int i= LIndex;i<=HIndex;i++){
			tempMergArr[i] = array[i];
		}
		int i = LIndex;
		int j = middle +1;
		int k = LIndex;
		
		while(i <= middle){
			if(tempMergArr[i] <= tempMergArr[j]){
				array[k] =tempMergArr[i];
				i++;
			}else{
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		
		while( i<=middle){
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}
