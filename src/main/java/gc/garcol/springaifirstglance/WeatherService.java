package gc.garcol.springaifirstglance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thaivc
 * @since 2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService
{

    private final ChatModel chatModel;

    public List<String> getWeather(String query)
    {
        UserMessage userMessage = new UserMessage(query);

        return chatModel.call(new Prompt((userMessage),
                OllamaOptions.builder().withFunction("currentWeather")
                    .build())
            ).getResults()
            .stream()
            .map(result -> result.getOutput().getContent())
            .toList();
    }

}
