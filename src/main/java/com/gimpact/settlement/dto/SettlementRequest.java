package com.gimpact.settlement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "Settlement request for a cleared trade")
public record SettlementRequest(
        @Schema(description = "Unique identifier for the trade", example = "f742d134-bbe5-4724-90e2-b6d95b37edaf") @NotNull UUID tradeId,
        @Schema(description = "Client ID for the party initiating the settlement", example = "e462c66f-3c49-43ab-aabb-45238bbd5b25") @NotNull UUID partyClientId,
        @Schema(description = "Counterparty Client ID for the settlement", example = "e431ee76-bc6f-4fc7-bf6f-14b39c1c0d20") @NotNull UUID counterpartyClientId,
        @Schema(description = "Name or identifier of the financial institution representing the party", example = "Bank Of ABC") @NotNull String partyInstitution,
        @Schema(description = "Name or identifier of the financial institution representing the counterparty", example = "Commere Bank") @NotNull String counterpartyInstitution,
        @Schema(description = "Type of instrument", example = "BOND, STOCK,ETF") @NotNull String instrument,
        @Schema(description = "The instrument or stock symbol", example = "AAPL,AMZ") @NotNull String ticker,
        @Schema(description = "The quantity of the instrument in the trade", example = "100") @NotNull int quantity,
        @Schema(description = "The price at which the instrument is traded", example = "120.26") @NotNull BigDecimal price
) {
}
