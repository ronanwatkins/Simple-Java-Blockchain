import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Ronan Watkins on 21/08/2017.
 */
public class Test {
    public static void main(String[] args) {
        Blockchain ronanCoin = new Blockchain();
        Scanner sc = new Scanner(System.in);
        String data;
        String date;
        System.out.println(ronanCoin);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while(true) {
            System.out.print("Enter data for new coin: ");
            data = sc.nextLine();
            date = simpleDateFormat.format(new Date());
            ronanCoin.addBlock(new Block(1, date, data, "0"));
            System.out.println(ronanCoin);
        }
    }
}
