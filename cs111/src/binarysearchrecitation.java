
public class binarysearchrecitation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"Elephant","Dog","Cat","Bigfoot","Bird","Alpaca","Buffalo","Rhinosaurus","Dogzilla","Beagle","Termite","Hamster","Penguin"};
		
		for(int i=1;i<array.length;i++){
			String temp=array[i];
			int j=i-1;
			for(;j>=0;j--){
				if(temp.compareTo(array[j])<0){
					array[j+1]=array[j];
				}else{
					break;
				}
			}
			array[j+1]=temp;
		}
		String search= "Bigfoot";
		
		
		int min=0;
		int max=array.length-1;
		while(min<=max){
			int mid=(min+max)/2;
			if(search.compareTo(array[mid])==0){
				System.out.println(search +" is at " + mid);
				break;
			}else if(search.compareTo(array[mid])<0){
				max = mid-1;
			}else{
				min = mid+1;
			}
		}
		for(int q=0;q<array.length;q++){
			System.out.println(array[q]);
		}
	}

}
