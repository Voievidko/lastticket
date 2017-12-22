package mappers;

import com.google.gson.JsonElement;
import entity.Answer;
import entity.Value;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class AnswerMapper {
    public Answer toDto(String input){
        Answer answer = null;
        ObjectMapper mapper = new ObjectMapper();

        try{
            answer = mapper.readValue(input, Answer.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
