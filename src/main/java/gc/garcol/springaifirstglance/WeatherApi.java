package gc.garcol.springaifirstglance;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author thaivc
 * @since 2024
 */
@Service
@RequiredArgsConstructor
public class WeatherApi
{
    private final RestClient restClient = RestClient.create();
    @Value("${weather.apikey}")
    private String key;

    public Weather.Response getWeather(String city)
    {
        return restClient.get()
            .uri(UriComponentsBuilder.fromUriString("https://api.weatherapi.com/v1/current.json")
                .queryParam("key", key)
                .queryParam("q", city)
                .toUriString())
            .retrieve()
            .body(Weather.Response.class);
    }
}
