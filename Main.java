package lesson6.hw6;
import okhttp3.*;

import java.io.IOException;

public class Main {
    public static final String WEATHER_URL = "https://yandex.ru/pogoda/saint-petersburg?via=reg";

    public static void main(String[] args) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(WEATHER_URL).newBuilder();

        HttpUrl httpUrl = urlBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder
                .get()
                .url(httpUrl)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);

        Response response = call.execute();

        System.out.println(response.body().string());
    }
}