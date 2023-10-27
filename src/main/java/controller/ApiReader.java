package controller;

import DTO.LocationDTO;
import DTO.WeatherDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiReader {

    public static WeatherDTO apiGet(String location) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String url = "https://vejr.eu/api.php?location="+location+"&degree=C";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS) // Sets a timeout for connecting to the server
                .readTimeout(30, TimeUnit.SECONDS)    // Sets a timeout for reading data from the server
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();

            return weatherParser(res);
        } catch (IOException e) {
            System.out.println("ERROR WITH THE API" + e.getMessage());
            throw new RuntimeException("ERROR WITH THE API" + e.getMessage());
        } finally {
            if(response != null){
                response.close();
            }
        }

    }

    public static LocationDTO apiGet1(int cityCode) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String url = "https://api.dataforsyningen.dk/postnumre/" + cityCode;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS) // Sets a timeout for connecting to the server
                .readTimeout(30, TimeUnit.SECONDS)  // Sets a timeout for reading data from the server
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Accept-Encoding", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String res = (response.body().string());
            if(res.isEmpty()) {
                System.out.println("RESPONSE IS EMPTY");
            } else if (response.code() == 400) {
                System.out.println("RESPONSE CODE IS 400");
            } else {
                return locationParser(res);
            }

        } catch (IOException e) {
            System.out.println("ERROR WITH THE API" + e.getMessage());
            throw new RuntimeException("ERROR WITH THE API" + e.getMessage());
        }
        return null;
    }

    private static LocationDTO locationParser(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LocationDTO locationDTO = gson.fromJson(json, LocationDTO.class);
        return locationDTO;
    }

    private static WeatherDTO weatherParser(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        WeatherDTO weatherDTO = gson.fromJson(json, WeatherDTO.class);
        return weatherDTO;
    }
}