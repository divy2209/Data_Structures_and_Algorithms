package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

// https://github.com/royalpranjal/Interview-Bit/blob/master/Greedy/GasStation.cpp
// https://www.youtube.com/watch?v=xWgbFI_rXJs
public class Gas_station {
	static Scanner scan = new Scanner(System.in);
	static int circuitCompletion(ArrayList<Integer> gas, ArrayList<Integer> cost) {
		int n = gas.size();
		int sum = 0, fuel = 0, start = 0;
		for(int i = 0; i<n; i++) {
			sum+=(gas.get(i)-cost.get(i));
			fuel+=(gas.get(i)-cost.get(i));
			if(fuel<0) {
				fuel = 0;
				start = i+1;
			}
		}
		if(sum>=0) return start%n;
		return -1;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> gas = input();
		ArrayList<Integer> cost = input();
		scan.close();
		System.out.println(circuitCompletion(gas, cost));
	}
}
