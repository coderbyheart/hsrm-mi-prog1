package uebung6;
import berdux.In;

public class QuerSumme {

	public static void main (String args[])
	{
		System.out.println("Bitte geben Sie eine Zahl ein:");
		String zahl = In.readString();
		
		long sum = 0;
		for(int i = 0; i < zahl.length(); i++) {
			sum += Long.parseLong(zahl.substring(i, i + 1));
		}
		System.out.println("Ziffernsumme: " + sum);
	}
	
}