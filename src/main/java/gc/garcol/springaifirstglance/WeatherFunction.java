package gc.garcol.springaifirstglance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author thaivc
 * @since 2024
 */
@Slf4j
@RequiredArgsConstructor
public class WeatherFunction implements Function<Weather.Request, Weather.Response>
{
    private final WeatherApi weatherApi;

    public Weather.Response apply(final Weather.Request request)
    {
        log.info("Requesting weather for city: {}", request.city());
        return weatherApi.getWeather(request.city());
    }
}
