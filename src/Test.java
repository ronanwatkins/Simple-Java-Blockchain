import java.util.Scanner;

/**
 * Created by Ronan Watkins on 21/08/2017.
 */
public class Test {
    public static void main(String[] args) {
        Blockchain ronanCoin = new Blockchain();
        Scanner sc = new Scanner(System.in);
        String data = "{}";
        System.out.println(ronanCoin);
        while(true) {
            System.out.print("Enter data for new coin: ");
            data = sc.nextLine();
            ronanCoin.addBlock(new Block(1, "10/07/2017", data, "0"));
            System.out.println(ronanCoin);
        }
    }
}
