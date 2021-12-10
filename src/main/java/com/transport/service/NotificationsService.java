package com.transport.service;

import com.transport.dao.NotificationsDAO;
import com.transport.dao.entity.NotificationsRecord;
import com.transport.dto.NotificationRequestBody;
import com.transport.dto.NotificationResponseBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@AllArgsConstructor
public class NotificationsService {

    private NotificationsDAO notificationsDAO;

    public NotificationResponseBody processNotificationRequest(NotificationRequestBody notificationRequestBody) throws ResponseStatusException {

        try {
            NotificationsRecord record = new NotificationsRecord();
            NotificationsRecord.ID id = new NotificationsRecord.ID();
            id.setInstant(Instant.from(notificationRequestBody.getInstant()));
            id.setUserId(notificationRequestBody.getUserID());

            record.setLongitude(notificationRequestBody.getLongitude());
            record.setLatitude(notificationRequestBody.getLatitude());
            record.setId(id);

            notificationsDAO.save(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        NotificationResponseBody responseBody = new NotificationResponseBody();
        responseBody.setMsg("Successful");
        return responseBody;
    }

}
