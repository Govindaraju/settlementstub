package com.gimpact.settlement;

import com.gimpact.settlement.dto.SettlementRequest;
import com.gimpact.settlement.dto.SettlementResponse;
import com.gimpact.settlement.dto.SettlementStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/settleTrade")
@Slf4j
public class SettlementController {

    private static SettlementResponse buildResponse(SettlementRequest settlementRequest, SettlementStatus status) {
        return SettlementResponse.builder()
                .tradeId(settlementRequest.tradeId())
                .settlementId(UUID.randomUUID())
                .partyId(settlementRequest.partyClientId())
                .counterpartyId(settlementRequest.counterpartyClientId())
                .status(status)
                .timestamp(LocalDateTime.now())
                .amount(new BigDecimal("1022.76"))
                .build();
    }

    @Operation(summary = "Settle a trade", description = "Simulates the settlement process after clearing.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trade settled successfully",
                    content = @Content(schema = @Schema(implementation = SettlementResponse.class))),
            @ApiResponse(responseCode = "400", description = "Settlement failed",
                    content = @Content(schema = @Schema(implementation = SettlementResponse.class)))
    })
    @PostMapping
    public ResponseEntity<SettlementResponse> settleTrade(@RequestBody SettlementRequest settlementRequest) {
        log.info("Received settlement request {}", settlementRequest);
        boolean settlementSuccessful = new Random().nextBoolean();
        SettlementResponse resp;
        if (!settlementSuccessful) {
            resp = buildResponse(settlementRequest, SettlementStatus.FAILURE);
            log.warn("Settlement failed {} ", resp);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(resp);
        }
        resp = buildResponse(settlementRequest, SettlementStatus.SUCCESS);
        log.info("Settlement successful {} ", resp);
        return ResponseEntity.ok(resp);
    }
}

