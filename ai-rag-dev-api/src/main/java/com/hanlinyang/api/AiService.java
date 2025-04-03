package com.hanlinyang.api;

import org.springframework.ai.chat.ChatResponse;
import reactor.core.publisher.Flux;

public interface AiService {

    ChatResponse generate(String model,String massage);

    Flux<ChatResponse> generateStream(String model,String massage);
}
