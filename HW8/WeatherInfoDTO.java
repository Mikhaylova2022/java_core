package lesson8.HW8;
import java.util.Date;

public class WeatherInfoDTO {
    private Integer key;
    private String name;
    private Date date;
    private String weatherText;
    private Double temperature;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherInfoDTO{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}