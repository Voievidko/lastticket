import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.trains.From;
import entity.trains.Value;

import java.util.ArrayList;
import java.util.List;
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
        List<String> trainNumbers = new ArrayList();
        trainNumbers.add("117К");
        trainNumbers.add("049К");
        trainNumbers.add("143К");
        trainNumbers.add("081К");
        trainNumbers.add("081Д");
        trainNumbers.add("771Л");

        String from = "Київ";
        String to = "Хмельницький";
        String dateTo = "2018-04-06";

        //String dateFrom = "08.01.2018";

        HttpPostClient httpPostClient = new HttpPostClient();
        httpPostClient.searchTicketWithDelay(from, to, dateTo, trainNumbers);


    }
}
