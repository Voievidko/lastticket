package mappers;

import entity.places.Places;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlacesMapperTest {
    private static final String PATH = "src/main/resources/places_response_1.json";
    private String json;
    private Places places;

    @Before
    public void readSampleJson(){
        this.json = TestUtils.readFile(PATH);
        places = PlacesMapper.toDto(json);
    }

    @Test
    public void checkIfDataObjectNotNullTest(){
        assertNotNull(places);
    }

    @Test
    public void checkTotalNumberOfPlacesInWagonTest(){
        assertEquals(41, places.getPlaces().getPlaceNumbers().size());
    }

    @Test
    public void checkNumberOfSomePlacesInWagonTest(){
        assertEquals("001", places.getPlaces().getPlaceNumbers().get(0));
        assertEquals("006", places.getPlaces().getPlaceNumbers().get(5));
    }

}