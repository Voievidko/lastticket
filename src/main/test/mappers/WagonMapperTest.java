package mappers;

import entity.wagons.Wagons;
import entity.wagons.Type;
import entity.wagons.Wagon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WagonMapperTest {
    private static final String PATH = "src/main/resources/wagon_types_response_1.json";
    private String json;
    private Wagons wagons;

    @Before
    public void readSampleJson(){
        this.json = TestUtils.readFile(PATH);
        wagons = WagonMapper.toDto(json);
    }

    @Test
    public void checkIfDataObjectNotNullTest(){
        assertNotNull(wagons);
    }

    @Test
    public void checkSizeOfWagonTypesListTest(){
        assertEquals(3, wagons.getTypes().size());
    }

    @Test
    public void checkTypeIdForWagonTypesArray(){
        List<String> expectedWagonTypeId = new ArrayList<>();
        expectedWagonTypeId.add("Л");
        expectedWagonTypeId.add("К");
        expectedWagonTypeId.add("П");

        List<String> actualTypes = wagons.getTypes().stream()
                .map(Type::getTypeId)
                .collect(Collectors.toList());
        assertEquals(expectedWagonTypeId, actualTypes);
    }

    @Test
    public void checkTitlesForWagonTypesArray(){
        List<String> expectedWagonTitles = new ArrayList<>();
        expectedWagonTitles.add("Люкс");
        expectedWagonTitles.add("Купе");
        expectedWagonTitles.add("Плацкарт");

        List<String> actualTitles = wagons.getTypes().stream()
                .map(Type::getTitle)
                .collect(Collectors.toList());
        assertEquals(expectedWagonTitles, actualTitles);
    }

    @Test
    public void checkFreePlacesForWagonTypesArray(){
        List<Integer> expectedFreePlacesNum = new ArrayList<>();
        expectedFreePlacesNum.add(10);
        expectedFreePlacesNum.add(78);
        expectedFreePlacesNum.add(114);

        List<Integer> actualFreePlacesNum = wagons.getTypes().stream()
                .map(Type::getFree)
                .collect(Collectors.toList());
        assertEquals(expectedFreePlacesNum, actualFreePlacesNum);
    }

    @Test
    public void checkSizeOfWagonsListTest(){
        assertEquals(5, wagons.getWagons().size());
    }

    @Test
    public void checkWagonNumbersTest(){
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(2);
        expectedNumbers.add(3);
        expectedNumbers.add(4);
        expectedNumbers.add(6);

        List<Integer> actualNumbers = wagons.getWagons().stream()
                .map(Wagon::getNum)
                .collect(Collectors.toList());
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void checkWagonsTypeIdTest(){
        List<String> expectedTypesId = new ArrayList<>();
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");

        List<String> actualTypesId = wagons.getWagons().stream()
                .map(Wagon::getTypeId)
                .collect(Collectors.toList());
        assertEquals(expectedTypesId, actualTypesId);
    }

    @Test
    public void checkWagonsFreePlacesTest(){
        List<Integer> expectedFreePlacesNum = new ArrayList<>();
        expectedFreePlacesNum.add(41);
        expectedFreePlacesNum.add(41);
        expectedFreePlacesNum.add(25);
        expectedFreePlacesNum.add(2);
        expectedFreePlacesNum.add(5);

        List<Integer> actualFreePlacesNum = wagons.getWagons().stream()
                .map(Wagon::getFree)
                .collect(Collectors.toList());
        assertEquals(expectedFreePlacesNum, actualFreePlacesNum);
    }
}
