package com.transport.controller;

import com.transport.api.NotificationsApi;
import com.transport.dto.NotificationRequestBody;
import com.transport.dto.NotificationResponseBody;
import com.transport.service.NotificationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class NotificationsController implements NotificationsApi {

    private NotificationsService notificationsService;

    @Override
    public ResponseEntity<NotificationResponseBody> collectNotificationsData(NotificationRequestBody notificationRequestBody) {
        NotificationResponseBody responseBody = notificationsService.processNotificationRequest(notificationRequestBody);
        return ResponseEntity.ok(responseBody);
    }
}
