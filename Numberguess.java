import java.util.Scanner;

public class NumberGuess{
	public static void main(String [] args){
		Scanner sc= new Scanner(System.in);

		int low= 1;
		int high= 100;
		int guess;
		String feedback;

		System.out.println("Think of a number between 1 to 100:");


		while(low<=high){	
				
		guess=(low+high)/2 ;
		
                System.out.println("Guess is:"+guess);

		System.out.print("Enter feedback (higher/lower/correct):");
		feedback = sc.nextLine();

		if(feedback.equalsIgnoreCase("higher")){
			low= guess+1;}
		else if(feedback.equalsIgnoreCase("lower")){
			high=guess-1;}

		else if(feedback.equalsIgnoreCase("correct")){
			System.out.println("Number guessed successfully");
			break;}
		else{
			System.out.println("Invalid feedback");}
	
}

		if(low>high){
			System.out.println("Inconsistet feedback");}
	}
   		
}

