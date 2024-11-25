package com.gimpact.settlement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Response to settlement request")
@Builder
public record SettlementResponse(
        @Schema(description = "Unique identifier for the trade", example = "e462c66f-3c49-43ab-aabb-45238bbd5b25") UUID tradeId,
        @Schema(description = "Unique identifier for the settlement.", example = "f742d134-bbe5-4724-90e2-b6d95b37edaf") UUID settlementId,


        @Schema(description = "Client ID for the party initiating the settlement.", example = "e431ee76-bc6f-4fc7-bf6f-14b39c1c0d20") UUID partyId,

        @Schema(description = "Counterparty Client ID for the settlement.", example = "fb8a4527-4f37-46b7-b436-d89d9b489ae5") UUID counterpartyId,

        @Schema(description = "Status of the settlement (e.g., 'SUCCESS', 'PENDING', 'FAILED').", example = "SUCCESS") SettlementStatus status,

        @Schema(description = "Timestamp when the settlement was completed.", example = "2024-11-24T10:15:30") LocalDateTime timestamp,

        @Schema(description = "Amount to be settled.", example = "15075.50") BigDecimal amount) {
}
