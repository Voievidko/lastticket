package mappers;

import entity.wagons.Data;
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
    public void checkSizeOfWagonsListTest(){
        assertEquals(5, data.getWagons().size());
    }

    @Test
    public void checkAllWagonNumbersTest(){
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
}
