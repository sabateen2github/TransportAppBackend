package com.transport.controller;

import com.transport.api.PassengersApi;
import com.transport.dto.LongtermRequestBody;
import com.transport.dto.LongtermResponseBody;
import com.transport.service.LongTermService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PassengersController implements PassengersApi {

    private LongTermService longTermService;

    @Override
    public ResponseEntity<LongtermResponseBody> collectPassengerData(LongtermRequestBody longtermRequestBody) {
        LongtermResponseBody responseBody = longTermService.processLongTermRecordRequest(longtermRequestBody);
        return ResponseEntity.ok(responseBody);
    }

}
