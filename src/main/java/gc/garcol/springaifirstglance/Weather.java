package gc.garcol.springaifirstglance;

import com.fasterxml.jackson.annotation.JsonClassDescription;

/**
 * @author thaivc
 * @since 2024
 */
public class Weather
{
    @JsonClassDescription("Get the weather in location") // // function description
    public record Request(String city)
    {
    }

    public record Response(Location location, Current current)
    {
    }

    public record Location(String name, String country)
    {
    }

    public record Current(String temp_c)
    {
    }
}
