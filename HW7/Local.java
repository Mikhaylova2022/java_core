package lesson7.HW7;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

public class Local {
    @JsonProperty("LocalObservationDateTime")
    private Date date;
    @JsonProperty("WeatherText")
    private String weatherText;
    private Double temperature;

    @JsonProperty("Temperature")
    public void setFromComplexTemperature(Map<String, Object> complexTemperature) {
        Map<String, Object> metric = (Map<String, Object>) complexTemperature.get("Metric");
        temperature = (Double) metric.get("Value");
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
        return "City{" +
                "date=" + date +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}