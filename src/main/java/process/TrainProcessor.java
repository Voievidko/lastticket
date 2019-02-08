package process;

import entity.trains.Train;
import entity.trains.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TrainProcessor {
    private String from;
    private String to;
    private String date;
    private List<String> trainNumbers;
    private List<String> trainTypes;
    private int numberOfTickets;

    private TrainPrinter trainPrinter;

    private List<Train> trains;

    private final static int DELAY_MIN = 10000; //ms
    private final static int DELAY_DELTA = 30000; //ms

    public static class Builder {
        private String from;
        private String to;
        private String date;
        private List<String> trainNumbers;
        private List<String> trainTypes;
        private int numberOfTickets;

        public Builder (String from, String to, String date){
            this.from = from;
            this.to = to;
            this.date = date;
        }

        public Builder requiredTrainNumbers(List<String> trainNumbers){
            this.trainNumbers = trainNumbers;
            return this;
        }

        public Builder requiredTrainTypes(List<String> trainTypes){
            this.trainTypes = trainTypes;
            return this;
        }

        public Builder numberOfTickets (int numberOfTickets) {
            this.numberOfTickets = numberOfTickets;
            return this;
        }

        public TrainProcessor build(){
            TrainProcessor trainProcessor = new TrainProcessor();
            trainProcessor.from = this.from;
            trainProcessor.to = this.to;
            trainProcessor.date = this.date;

            if (trainNumbers == null) {
                trainNumbers = new ArrayList<>();
            } else {
                trainProcessor.trainNumbers = this.trainNumbers;
            }
            if (trainTypes == null){
                trainTypes = new ArrayList<>();
            } else {
                trainProcessor.trainTypes = this.trainTypes;
            }
            if (numberOfTickets == 0) {
                this.numberOfTickets = 1;
            } else {
                trainProcessor.numberOfTickets = this.numberOfTickets;
            }
            trainProcessor.trainPrinter = new TrainPrinter(trainProcessor);
            return trainProcessor;
        }
    }

    private TrainProcessor (){
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public List<String> getTrainNumbers() {
        return trainNumbers;
    }

    public List<String> getTrainTypes() {
        return trainTypes;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void proceed(){
        HttpPostClient httpPostClient = new HttpPostClient();

        String cityCodeFrom = CityPicker.getCityCode(from);
        String cityCodeTo = CityPicker.getCityCode(to);

        trainPrinter.printCityCodeInformation(to, from, cityCodeTo, cityCodeFrom);

        trains = null;
        boolean flag = true;

        while (flag){
            try {
                trains = httpPostClient.sendPost(cityCodeFrom, cityCodeTo, date);
                if (trains == null){
                    throw new IllegalArgumentException("Data with trains info is null.");
                }

                if (isCorrectPlaceExist(trains)){
                    trainPrinter.printTicketsFoundMessage();
                    trainPrinter.showPopUpMessage();
                    flag = false;
                    System.exit(0);
                } else {
                    int sleepTime = getDelay();
                    trainPrinter.printNoTrainsMessage(sleepTime, trains);
                    Thread.sleep(sleepTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isCorrectPlaceExist(List<Train> trains){
        if (trains == null || trains.isEmpty()){
            return false;
        }
        return trains.stream()
                .filter(a -> isTrainNumberExistInRequiredTrainList(a))
                .filter(a -> isCarTypesExistInRequiredTrainList(a))
                .filter(a -> isEnoughTickets(a))
                .collect(Collectors.toList())
                .size() > 0;
    }

    //Check if input train number meets required trainNumbers list
    private boolean isTrainNumberExistInRequiredTrainList(Train train){
        if (trainNumbers == null || trainNumbers.isEmpty()){
            return true;
        }
        return trainNumbers.contains(train.getNum());
    }

    //Check if input train type meets required train types (like "К" / "Л" / "П")
    private boolean isCarTypesExistInRequiredTrainList(Train train){
        if (trainTypes == null || trainTypes.isEmpty()){
            return true;
        }
        for (Type type : train.getTypes()){
            if (trainTypes.contains(type.getId())){
                return true;
            }
        }
        return false;
    }

    //Check if input train type meets required number of tickets
    private boolean isEnoughTickets(Train train){
        int freePlacesInOneTrain = 0;
        for (Type type : train.getTypes()){
            freePlacesInOneTrain += type.getPlaces();
        }
        return numberOfTickets <= freePlacesInOneTrain;
    }

    private int getDelay(){
        Random rnd = new Random();
        return (int)(DELAY_MIN + DELAY_DELTA * rnd.nextDouble());
    }

//    private boolean dateValidation() throws IllegalFormatException, IllegalStateException {
//        //Validate format

          //Validate logic
//        Integer year = Integer.parseInt(date.substring(0, 4));
//        Integer month = Integer.parseInt(date.substring(5, 7));
//        Integer day = Integer.parseInt(date.substring(8, 10));
//        LocalDate localDate = LocalDate.now();
//    }
}