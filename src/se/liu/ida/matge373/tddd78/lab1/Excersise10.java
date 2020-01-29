package se.liu.ida.matge373.tddd78.lab1;

public class Excersise10
{
    public static void main(String[] args) {
	int tal = 16777217;
	float decimaltal = tal;
	int tillbaka = (int)decimaltal;
	int big = 2147483647;
	long bigger = (long)big + 1;
	System.out.println("Tal: "+ tal + ", Decimal: " + decimaltal + ", Tillbaka: " + tillbaka+
			   ", Big: " + big + ", Bigger: " + bigger);
    }
}
