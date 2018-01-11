import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.trains.From;
import entity.trains.Value;

import java.util.Scanner;


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
//        System.out.print( "Date (in format DD.MM.YYYY): " );
//        String date = scanner.nextLine();
//        System.out.println();
//        System.out.println();
//        System.out.println();
        String from = "Київ";
        String to = "Самбір";
        String dateTo = "09.01.2018";
        //String dateFrom = "08.01.2018";

        HttpPostClient httpPostClient = new HttpPostClient();
        httpPostClient.searchTicketWithDelay(to,from,dateTo);


    }
}
