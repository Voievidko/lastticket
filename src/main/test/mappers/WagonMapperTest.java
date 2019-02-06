package mappers;

import entity.wagons.Data;
import entity.wagons.Type;
import entity.wagons.Wagon;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WagonMapperTest {
    private static final String PATH = "src/main/resources/train_wagons_response.json";
    private String json;
    private Data data;

    @Before
    public void readSampleJson(){
        this.json = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                this.json += sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = WagonMapper.toDto(json);
    }

    @Test
    public void checkIfDataObjectNotNullTest(){
        assertNotNull(data);
    }

    @Test
    public void checkSizeOfWagonTypesListTest(){
        assertEquals(3, data.getTypes().size());
    }

    @Test
    public void checkTypeIdForWagonTypesArray(){
        List<String> expectedWagonTypeId = new ArrayList<>();
        expectedWagonTypeId.add("Л");
        expectedWagonTypeId.add("К");
        expectedWagonTypeId.add("П");

        List<String> actualTypes = data.getTypes().stream()
                .map(Type::getTypeId)
                .collect(Collectors.toList());
        assertEquals(expectedWagonTypeId,actualTypes);
    }

    @Test
    public void checkTitlesForWagonTypesArray(){
        List<String> expectedWagonTitles = new ArrayList<>();
        expectedWagonTitles.add("Люкс");
        expectedWagonTitles.add("Купе");
        expectedWagonTitles.add("Плацкарт");

        List<String> actualTitles = data.getTypes().stream()
                .map(Type::getTitle)
                .collect(Collectors.toList());
        assertEquals(expectedWagonTitles,actualTitles);
    }

    @Test
    public void checkFreePlacesForWagonTypesArray(){
        List<Integer> expectedFreePlacesNum = new ArrayList<>();
        expectedFreePlacesNum.add(10);
        expectedFreePlacesNum.add(78);
        expectedFreePlacesNum.add(114);

        List<Integer> actualFreePlacesNum = data.getTypes().stream()
                .map(Type::getFree)
                .collect(Collectors.toList());
        assertEquals(expectedFreePlacesNum,actualFreePlacesNum);
    }

    @Test
    public void checkSizeOfWagonsListTest(){
        assertEquals(5, data.getWagons().size());
    }

    @Test
    public void checkWagonNumbersTest(){
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(2);
        expectedNumbers.add(3);
        expectedNumbers.add(4);
        expectedNumbers.add(6);

        List<Integer> actualNumbers = data.getWagons().stream()
                .map(Wagon::getNum)
                .collect(Collectors.toList());
        assertEquals(expectedNumbers,actualNumbers);
    }

    @Test
    public void checkWagonsTypeIdTest(){
        List<String> expectedTypesId = new ArrayList<>();
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");
        expectedTypesId.add("П");

        List<String> actualTypesId = data.getWagons().stream()
                .map(Wagon::getTypeId)
                .collect(Collectors.toList());
        assertEquals(expectedTypesId,actualTypesId);
    }

    @Test
    public void checkWagonsFreePlacesTest(){
        List<Integer> expectedFreePlacesNum = new ArrayList<>();
        expectedFreePlacesNum.add(41);
        expectedFreePlacesNum.add(41);
        expectedFreePlacesNum.add(25);
        expectedFreePlacesNum.add(2);
        expectedFreePlacesNum.add(5);

        List<Integer> actualFreePlacesNum = data.getWagons().stream()
                .map(Wagon::getFree)
                .collect(Collectors.toList());
        assertEquals(expectedFreePlacesNum,actualFreePlacesNum);
    }
}
