import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Insertion {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("insertion.dat"));
		int count = scan.nextInt();
		String blah = scan.nextLine();
		for(int i=0;i<count;i++){
			String[] input = scan.nextLine().split(" ");
			for(int index=1;index<input.length;index++){
				String value=input[index];
				for(int num=0;num<index;num++){
					if(translate(value)<translate(input[num])){
						for(int num2=index;num2>num;num2--){
							input[num2]=input[num2-1];
						}
						input[num]=value;
						break;
					}
					//System.out.println(Arrays.toString(input));
				}
				System.out.println(Arrays.toString(input));
				
			}
			System.out.println("---------------------");
		
		}

	}
	public static int translate(String s){
		if(s.equals("T")){
			return 10;
		}
		else if(s.equals("J")){
			return 11;
		}
		else if(s.equals("Q")){
			return 12;
		}
		else if(s.equals("K")){
			return 13;
		}
		else if(s.equals("A")){
			return 14;
		}
		else{
			return Integer.parseInt(s);
		}
	}

}