package process;

import java.util.ArrayList;
import java.util.List;

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
        trainNumbers.add("143К");
//        trainNumbers.add("749Д");


        List<String> neededTypes = new ArrayList();
        neededTypes.add("П");
//        neededTypes.add("П");
//        neededTypes.add("К");

        int placeNumber = 6;
        boolean singleWagon = false;

        String from = "Київ";
        String to = "Івано-Франківськ";
        String date = "2019-03-28"; //YYYY-MM-DD


        TrainProcessor trainProcessor = new TrainProcessor.Builder(from, to, date)
                .requiredTrainTypes(neededTypes)
                .requiredTrainNumbers(trainNumbers)
                .numberOfTickets(placeNumber)
                .singleWagon(singleWagon)
                .build();
        trainProcessor.proceed();
    }
}
