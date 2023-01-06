package lesson8.HW8;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class WeatherClient {
    private static final String API_KEY_PARAM = "apikey";
    private static final String API_KEY = "L8jY9hzHqmGxBxDAAgmEUYztLuVwkgG5";
    private static final String LOCATION_WEATHER_URL = "https://dataservice.accuweather.com/currentconditions/v1/";
    private static final String LOCATION_INFO_URL = "http://dataservice.accuweather.com/locations/v1/";

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public WeatherInfoDTO getCity(int cityKey) {
        try {
            Mod cityModel = OBJECT_MAPPER.readValue(
                    getResponse(HttpUrl.parse(LOCATION_INFO_URL + cityKey).newBuilder()
                            .addQueryParameter(API_KEY_PARAM, API_KEY)
                            .build()),
                    Mod.class);

            CityWeatherMod cityWeatherModel = OBJECT_MAPPER.readValue(
                    getResponse(HttpUrl.parse(LOCATION_WEATHER_URL + cityKey).newBuilder()
                            .addQueryParameter(API_KEY_PARAM, API_KEY)
                            .build()),
                    new TypeReference<List<CityWeatherMod>>() {
                    }
            ).get(0);

            return getWeatherInfoDTO(cityModel, cityWeatherModel);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private String getResponse(HttpUrl httpUrl) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder
                .get()
                .url(httpUrl)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);

        Response response = call.execute();

        return response.body().string();
    }

    private WeatherInfoDTO getWeatherInfoDTO(Mod cityModel, CityWeatherMod cityWeatherModel) {
        WeatherInfoDTO weatherInfoDTO = new WeatherInfoDTO();
        weatherInfoDTO.setKey(Integer.parseInt(cityModel.getKey()));
        weatherInfoDTO.setName(cityModel.getName());
        weatherInfoDTO.setWeatherText(cityWeatherModel.getWeatherText());
        weatherInfoDTO.setDate(cityWeatherModel.getDate());
        weatherInfoDTO.setTemperature(cityWeatherModel.getTemperature());
        return weatherInfoDTO;
    }
}