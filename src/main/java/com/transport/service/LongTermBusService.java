package com.transport.service;

import com.transport.dao.LongTermBusDAO;
import com.transport.dao.entity.LongTermBusRecord;
import com.transport.dto.LongTermBusRequestBody;
import com.transport.dto.LongTermBusResponseBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@AllArgsConstructor
public class LongTermBusService {

    private LongTermBusDAO longTermDAO;

    public LongTermBusResponseBody processBusRequest(LongTermBusRequestBody longtermRequestBody) throws ResponseStatusException {

        try {
            LongTermBusRecord record = new LongTermBusRecord();
            LongTermBusRecord.ID id = new LongTermBusRecord.ID();
            id.setInstant(Instant.from(longtermRequestBody.getInstant()));
            id.setBusId(longtermRequestBody.getBusID());

            record.setLongitude(longtermRequestBody.getLongitude());
            record.setLatitude(longtermRequestBody.getLatitude());
            record.setId(id);

            longTermDAO.save(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LongTermBusResponseBody responseBody = new LongTermBusResponseBody();
        responseBody.setMsg("Successful");
        return responseBody;
    }

}
