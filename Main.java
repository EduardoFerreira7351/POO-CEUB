public class Main {
    public static void main(String[] args) {
        int a=10, b=5, c=0;
        if (a >= 5){
            //Bloco true
            c = a + b;
            System.out.print("Sei somar! O resultado é: ");
            System.err.println(c);
        }
        else {
            //bloco False
            c = a - b;
            System.out.print("sei subtrair! O resultado é: ");
            System.out.println(c);
        }
    }
}
