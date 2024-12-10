package com.yatmk.app.infrastructure.services;

import java.util.Objects;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.yatmk.app.common.utility.StringTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendToUser(String userId, Object object) {
        if (Objects.isNull(userId) || Objects.isNull(object) || userId.trim().isEmpty()) {
            return;
        }
        log.info("message : " + object.toString());

        String url = StringTemplate.template("/api/notifications/topic/notify/user/${userId}")
                .addParameter("userId", userId)
                .build();

        log.info("sending notification to user {}", userId);
        messagingTemplate.convertAndSend(url, object);
        log.info("notification was sent to user {}", userId);

    }

}
