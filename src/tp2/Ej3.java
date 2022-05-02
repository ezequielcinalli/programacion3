package tp2;

public class Ej3 {
    public static void main(String[] args) {
        Ej3 ej3 = new Ej3();
        System.out.println(ej3.decimalToBinary(13));
        System.out.println(ej3.decimalToBinary(24));
    }

    public String decimalToBinary(int quotient) {
        if (quotient == 0)
            return "";
        else {
            return decimalToBinary(quotient / 2) + quotient % 2;
        }
    }

}
