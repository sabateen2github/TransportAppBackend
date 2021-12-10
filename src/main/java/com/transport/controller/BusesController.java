package com.transport.controller;

import com.transport.api.BusesApi;
import com.transport.dto.LongTermBusRequestBody;
import com.transport.dto.LongTermBusResponseBody;
import com.transport.service.LongTermBusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class BusesController implements BusesApi {

    private LongTermBusService busRecordsService;

    @Override
    public ResponseEntity<LongTermBusResponseBody> collectBusesData(LongTermBusRequestBody longTermBusRequestBody) {
        LongTermBusResponseBody responseBody = busRecordsService.processBusRequest(longTermBusRequestBody);
        return ResponseEntity.ok(responseBody);
    }
}
