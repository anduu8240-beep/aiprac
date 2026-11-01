import java.util.Scanner;

public class TOH{

	static void hanoi(int n, char src,char aux,char dest){
	if(n==1){System.out.println("Move disk 1 from " + src + "to" + dest); 
	return;
	}
	hanoi(n-1,src,dest,aux);
	System.out.println("move disk" + n + "from" + src + "to" + dest);
	hanoi(n-1,aux,src,dest);}

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of disks:");
		int n= sc. nextInt();
		hanoi(n,'A','B','C');
		System.out.println("All disks are moved successfully");

}

}