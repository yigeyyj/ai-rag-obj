package com.hanlinyang.tirgger.http;

import com.hanlinyang.api.AiService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ollama/")
public class OllamaController implements AiService {
    @Resource
    private OllamaChatClient chatClient;

    /**
     * curl http://localhost:8090/api/v1/ollama/generate?model=deepseek-r1:1.5b&message=hi
     */
    @RequestMapping(value = "generate", method = RequestMethod.GET)
    @Override
    public ChatResponse generate(@RequestParam String model, @RequestParam String message) {
        return chatClient.call(new Prompt(
                message,
                OllamaOptions.create().withModel(model)
        ));
    }

    /**
     * curl http://localhost:8090/api/v1/ollama/generate_stream?model=deepseek-r1:1.5b&message=1+1
     */
    @RequestMapping(value = "generate_stream", method = RequestMethod.GET)
    public Flux<ChatResponse> generateStream(@RequestParam String model, @RequestParam String message) {
        return chatClient.stream(new Prompt(
                message,
                OllamaOptions.create()
                        .withModel(model)
        ));
    }
}
