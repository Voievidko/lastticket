package mappers;

import entity.trains.Trains;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrainsMapperTest {
    private static final String PATH = "src/main/resources/train_list_response_2.json";
    private String json;
    private Trains trains;

    @Before
    public void readSampleJson(){
        this.json = TestUtils.readFile(PATH);
        trains = TrainsMapper.toDto(json);
    }

    @Test
    public void checkIfDataObjectNotNullTest(){
        assertNotNull(trains);
    }

    @Test
    public void checkTotalNumberOfTrainsTest(){
        assertEquals(23, trains.getTrains().size());
    }

    @Test
    public void checkSomeTrainNumbers(){
        assertEquals("015К", trains.getTrains().get(0).getNum());
        assertEquals("015О", trains.getTrains().get(1).getNum());
        assertEquals("111О", trains.getTrains().get(2).getNum());
        assertEquals("073А", trains.getTrains().get(3).getNum());
        assertEquals("749Д", trains.getTrains().get(8).getNum());
        assertEquals("743Ш", trains.getTrains().get(10).getNum());
        assertEquals("049К", trains.getTrains().get(15).getNum());
        assertEquals("046Д", trains.getTrains().get(22).getNum());
    }

    @Test
    public void checkSizeOfTypes(){
        assertEquals(2, trains.getTrains().get(1).getTypes().size());
        assertEquals(2, trains.getTrains().get(4).getTypes().size());
    }

    @Test
    public void checkAllFieldsInSecondTrain(){
        assertEquals("015О", trains.getTrains().get(1).getNum());
        assertEquals(0, trains.getTrains().get(1).getCategory());
        assertEquals(0, trains.getTrains().get(1).getIsTransformer());
        assertEquals("6:22", trains.getTrains().get(1).getTravelTime());

        //from field
        assertEquals("2200001", trains.getTrains().get(1).getFrom().getCode());
        assertEquals("Київ-Пасажирський", trains.getTrains().get(1).getFrom().getStation());
        assertEquals("Харків-Пас", trains.getTrains().get(1).getFrom().getStationTrain());
        assertEquals("середа, 03.04.2019", trains.getTrains().get(1).getFrom().getDate());
        assertEquals("01:17", trains.getTrains().get(1).getFrom().getTime());
        assertEquals(1554243420, trains.getTrains().get(1).getFrom().getSortTime());
        assertEquals("2019-04-03", trains.getTrains().get(1).getFrom().getSrcDate());

        //to field
        assertEquals("2218000", trains.getTrains().get(1).getTo().getCode());
        assertEquals("Львів", trains.getTrains().get(1).getTo().getStation());
        assertEquals("Львів", trains.getTrains().get(1).getTo().getStationTrain());
        assertEquals("середа, 03.04.2019", trains.getTrains().get(1).getTo().getDate());
        assertEquals("07:39", trains.getTrains().get(1).getTo().getTime());
        assertEquals(1554266340, trains.getTrains().get(1).getTo().getSortTime());

        //types
        assertEquals("Л", trains.getTrains().get(1).getTypes().get(0).getId());
        assertEquals("Люкс", trains.getTrains().get(1).getTypes().get(0).getTitle());
        assertEquals("Л", trains.getTrains().get(1).getTypes().get(0).getLetter());
        assertEquals(15, trains.getTrains().get(1).getTypes().get(0).getPlaces());
        assertEquals("К", trains.getTrains().get(1).getTypes().get(1).getId());
        assertEquals("Купе", trains.getTrains().get(1).getTypes().get(1).getTitle());
        assertEquals("К", trains.getTrains().get(1).getTypes().get(1).getLetter());
        assertEquals(22, trains.getTrains().get(1).getTypes().get(1).getPlaces());

        assertEquals("2005-04-04", trains.getTrains().get(1).getChild().getMinDate());
        assertEquals("2019-03-12", trains.getTrains().get(1).getChild().getMaxDate());
        assertEquals(1, trains.getTrains().get(1).getAllowStudent());
        assertEquals(1, trains.getTrains().get(1).getAllowBooking());
        assertEquals(0, trains.getTrains().get(1).getIsCis());
        assertEquals(0, trains.getTrains().get(1).getIsEurope());
        assertEquals(1, trains.getTrains().get(1).getAllowPrivilege());
    }
}