package gc.garcol.springaifirstglance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thaivc
 * @since 2024
 */
@RestController
@RequiredArgsConstructor
public class WeatherController
{

    private final WeatherService weatherService;

    @GetMapping("/weather")
    ResponseEntity<List<String>> getWeather(@RequestParam String query)
    {
        return ResponseEntity.ok(weatherService.getWeather(query));
    }

}
