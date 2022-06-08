import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Oynamak istediğiniz satır boyutunu giriniz giriniz : ");
        int row = sc.nextInt();
        System.out.print("Oynamak istediğiniz sütun boyutunu giriniz giriniz : ");
        int col = sc.nextInt();
        MineSweeper mineSweeper = new MineSweeper(row, col);
        mineSweeper.run(row, col);
    }
}
