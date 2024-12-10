package com.gimpact.settlement;

import com.gimpact.settlement.exception.SettlementException;
import lombok.extern.slf4j.Slf4j;
import org.gimpact.dto.common.TradeOrderStatus;
import org.gimpact.dto.settlement.SettlementRequest;
import org.gimpact.dto.settlement.SettlementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/settleTrade")
@Slf4j
public class SettlementController {
    @PostMapping
    public ResponseEntity<SettlementResponse> settleTrade(@Validated @RequestBody SettlementRequest settlementRequest) {

        if (Math.random() < 0.1) {
            throw new SettlementException("Settlement failed due to insufficient funds");
        }

        LocalDateTime settlementDate = LocalDateTime.now();
        SettlementResponse response = new SettlementResponse(
                settlementRequest.tradeId(),
                TradeOrderStatus.SETTLED,
                settlementDate);
        return ResponseEntity.ok(response);
    }
}

