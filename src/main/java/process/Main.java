package process;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
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
        trainNumbers.add("150Л");
//        trainNumbers.add("749Д");


        List<String> neededTypes = new ArrayList();
//        neededTypes.add("Л");
        neededTypes.add("П");
//        neededTypes.add("К");

        int placeNumber = 1;

        String from = "Івано-Франківськ";
        String to = "Київ";
        String date = "2019-02-08"; //YYYY-MM-DD


        TrainProcessor trainProcessor = new TrainProcessor.Builder(from, to, date)
                .requiredTrainTypes(neededTypes)
                .requiredTrainNumbers(trainNumbers)
                .numberOfTickets(placeNumber)
                .build();
        trainProcessor.proceed();
    }
    */
    public static void main(String[] args) {
        HttpPostClient httpPostClient = new HttpPostClient();
        httpPostClient.requestAllAvaliableWagonNumbersByType("2200001", "2218000", "2019-02-05",
                "049К", "П");
//        httpPostClient.requestAllAvaliablePlacesInWagon("2200001", "2218000", "2019-02-05",
//                "049К", "1", "П");

        /*from: 2200001
        to: 2218005
        train: 049К
        date: 2019-02-05
        wagon_num: 1
        wagon_type: П
        wagon_class: Б
        cached_scheme[]: П01
        */
    }
}
