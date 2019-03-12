package process;

import entity.trains.Train;

import javax.swing.*;
import java.util.List;

public class TrainPrinter {

    private TrainProcessor trainProcessor;

    public TrainPrinter(TrainProcessor trainProcessor){
        this.trainProcessor = trainProcessor;
    }

    public void printCityCodeInformation (String to, String from, String cityCodeTo, String cityCodeFrom){
        System.out.println("Code for " + from + ": " + cityCodeFrom);
        System.out.println("Code for " + to + ": " + cityCodeTo);
        System.out.println("Start: ");
    }

    public void printTicketsFoundMessage (){
        System.out.println("Trains was found");
    }

    public void showPopUpMessage(){
        JOptionPane pane = new JOptionPane("Tickets was found");
        JDialog dialog = pane.createDialog("Buy!");
        dialog.setAlwaysOnTop(true);
        dialog.show();
    }

    public void printNoTrainsMessage (int sleepTime, List<Train> trains){
        System.out.println("There no trains now");
        System.out.println("        Delay: " + (double)sleepTime/1000 + " seconds; ");
        System.out.println("        Total numbers of trains: " + trains.size() + "; ");
        System.out.println("        Numbers: " + getNumbersOfTrainsInOneLine(trains));
        System.out.println("        Search in scope of train numbers: " + trainProcessor.getTrainNumbers());
        System.out.println("        Search for types: " + trainProcessor.getTrainTypes());
        System.out.println("        Number of required tickets in one train: " + trainProcessor.getNumberOfTickets());
        System.out.println("        In single wagon: " + trainProcessor.isSingleWagon());
        System.out.println();
    }

    private String getNumbersOfTrainsInOneLine(List<Train> trains){
        String prettyTrainList = "[";
        for (int i = 0; i < trains.size(); i++){
            prettyTrainList += trains.get(i).getNum();
            if (i != trains.size() - 1) {
                prettyTrainList += ", ";
            }
        }
        return prettyTrainList + "]";
    }
}
