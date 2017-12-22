package mappers;

import entity.Answer;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class AnswerSerializerTest {
    private static final String PATH = "src\\main\\resources\\answer.json";

    @Test
    public void baseTest(){
        String json = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                json += sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        AnswerMapper answerMapper = new AnswerMapper();
        Answer answer = answerMapper.toDto(json);

        assertNotNull(answer);
        assertEquals(6, answer.getValue().size());
        assertEquals("Сидячий другого класу",answer.getValue().get(0).getTypes().get(0).getTitle());


    }
}