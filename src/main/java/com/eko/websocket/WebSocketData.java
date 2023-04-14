package com.eko.websocket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * Thursday, 13/04/23 10.40
 */

@Setter
@Getter
@Builder
public class WebSocketData {
    @Builder.Default
    private String eventId = UUID.randomUUID().toString();

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    private String eventName;

    private String bucket;
}
