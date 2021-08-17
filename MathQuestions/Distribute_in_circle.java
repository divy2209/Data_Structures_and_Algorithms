package MathQuestions;

import java.util.Scanner;

//{Starting point + Total chocolates -1(chocolate given to that starting person)}%Total people
//https://www.youtube.com/watch?v=lvRGZkNXPQI
public class Distribute_in_circle {
	static int lastPerson(int chocolates, int totalPeople, int start) {
		int ans = (start+chocolates-1)%totalPeople;
		if(ans!=0) return ans;
		else return totalPeople;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int chocolates = scan.nextInt();
		int totalPeople = scan.nextInt();
		int start = scan.nextInt();
		scan.close();
		int lastPerson = lastPerson(chocolates, totalPeople, start);
		System.out.println(lastPerson);
	}

}
