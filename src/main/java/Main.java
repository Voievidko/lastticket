import java.util.ArrayList;
import java.util.List;

/**
 * Created by voievidko_ri on 26.10.2017.
 */
public class Main {
    public static void main(String[] args) {


//        Scanner scanner = new Scanner( System.in);
//        System.out.println("UZ Ticket scanner");
//        System.out.print("From station (in ukrainian): ");
//        String from = scanner.nextLine();
//        System.out.print("To station (in ukrainian): ");
//        String to = scanner.nextLine();
//        System.out.print( "Date (in format YYYY-MM-DD): " );
//        String date = scanner.nextLine();
//        System.out.println();
//        System.out.println();
//        System.out.println();
        List<String> trainNumbers = new ArrayList();
        trainNumbers.add("117К");
        trainNumbers.add("049К");
        trainNumbers.add("143К");
        trainNumbers.add("081К");
        trainNumbers.add("081Д");
        trainNumbers.add("771Л");

        String from = "Київ";
        String to = "Хмельницький";
        String date = "2018-04-06"; //YYYY-MM-DD

        HttpPostClient httpPostClient = new HttpPostClient();
        httpPostClient.searchTicketWithDelay(from, to, date, trainNumbers);


    }
}
