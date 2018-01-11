package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trains {
    private List<Value> value;
    private Error error;
    private Data data;
    private Captcha captcha;

    public Trains() {
    }

    public Trains(List<Value> value, Error error, Data data, Captcha captcha) {
        this.value = value;
        this.error = error;
        this.data = data;
        this.captcha = captcha;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Captcha getCaptcha() {
        return captcha;
    }

    public void setCaptcha(Captcha captcha) {
        this.captcha = captcha;
    }
}
