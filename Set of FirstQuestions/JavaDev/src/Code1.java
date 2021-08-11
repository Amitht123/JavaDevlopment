import java.util.Scanner;

public class Code1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,count;
		System.out.println("Enter the Number of Elements to store");
		Scanner sc = new Scanner(System.in);
		 count = sc.nextInt();
		int array[]= new int[count];
		for(i=0;i< count ;i++) {
			System.out.println("Please Enter your " + i + "th element :");
			array[i] = sc.nextInt();
		}
		System.out.println("Elements Before Sorting:");
		for(i=0;i<count;i++) {
			System.out.print(array[i] + " ");
			System.out.println();
		}
		System.out.println("Elements After Sorting:");
		for(i=0;i<array.length;i++) {
			for(j=i+1;j<array.length;j++) {
				int tmp=0;
				if(array[i]>array[j]) {
					tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
			}
			System.out.print(array[i] + " ");
			System.out.println();
		}
		int midvalue = array[0] + (array[array.length - 1]-array[0])/2;
		System.out.println("MidValue of Sorted Array is: " + midvalue);
	}
}
