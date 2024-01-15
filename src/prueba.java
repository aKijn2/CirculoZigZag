import java.util.Scanner;

public class prueba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int numero = scanner.nextInt();
        for (int i = 0; i < numero; i++) {
            factorial(i);
        }
    }

    public static void factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
            String o = "o";
            i = o.length();
        }
        System.out.println(resultado);
    }
}