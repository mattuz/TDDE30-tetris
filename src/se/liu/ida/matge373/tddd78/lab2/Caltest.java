package se.liu.ida.matge373.tddd78.lab2;

public class Caltest
{
    public static void main(String[] args) {
        Cal cal1 = new Cal();
        cal1.book(2000, "March", 14, 2, 56, 14, 30, "Lunch");
        cal1.book(2020, "November", 25, 0, 00, 23, 59, "Födelsedag");
        cal1.book(2100, "December", 5, 8, 00, 13, 37, "Coronaviruset har utplånat mänskligheten");
        cal1.book(2000, "February", 1, 21, 00, 22, 56, "Sova");
        cal1.book(2000, "October", 30, 6, 30, 17, 00, "Skoldag");
        cal1.book(1978, "May", 11, 10, 10, 13, 00, "Chill");
        cal1.show();
    }
}
