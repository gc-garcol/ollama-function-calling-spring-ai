package gc.garcol.springaifirstglance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

/**
 * @author thaivc
 * @since 2024
 */
@Configuration
public class WeatherConfig
{
    @Bean
    @Description("Get the weather in location") // function description
    public Function<Weather.Request, Weather.Response> currentWeather(
        final WeatherApi weatherApi
    )
    {
        return new WeatherFunction(weatherApi);
    }
}
