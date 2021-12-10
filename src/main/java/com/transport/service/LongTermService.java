package com.transport.service;

import com.transport.dao.LongTermDAO;
import com.transport.dao.entity.LongTermRecord;
import com.transport.dto.LongtermRequestBody;
import com.transport.dto.LongtermResponseBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@AllArgsConstructor
public class LongTermService {

    private LongTermDAO longTermDAO;

    public LongtermResponseBody processLongTermRecordRequest(LongtermRequestBody longtermRequestBody) throws ResponseStatusException {

        try {
            LongTermRecord record = new LongTermRecord();
            LongTermRecord.ID id = new LongTermRecord.ID();
            id.setInstant(Instant.from(longtermRequestBody.getInstant()));
            id.setUserId(longtermRequestBody.getUserID());

            record.setLongitude(longtermRequestBody.getLongitude());
            record.setLatitude(longtermRequestBody.getLatitude());
            record.setId(id);

            longTermDAO.save(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LongtermResponseBody responseBody = new LongtermResponseBody();
        responseBody.setMsg("Successful");
        return responseBody;
    }

}
