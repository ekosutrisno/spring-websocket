package com.eko.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eko Sutrisno
 * Thursday, 13/04/23 10.36
 */
@Slf4j
@RestController
@RequestMapping(path = "api/v1/web-socket")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public void sendToFE(@RequestParam String event) {
        messagingTemplate
                .convertAndSend("/topic/data.admin",
                        WebSocketData.builder()
                                .eventName(event.toUpperCase())
                                .bucket("DATA_ADMIN")
                                .build()
                );

        messagingTemplate
                .convertAndSend("/topic/message.admin",
                        WebSocketData.builder()
                                .eventName(event.toUpperCase())
                                .bucket("MESSAGE_ADMIN")
                                .build()
                );

        messagingTemplate
                .convertAndSend("/topic/notification.admin",
                        WebSocketData.builder()
                                .eventName(event.toUpperCase())
                                .bucket("NOTIFICATION_ADMIN")
                                .build()
                );

        log.info("New Event {} Created.", event);
    }
}
