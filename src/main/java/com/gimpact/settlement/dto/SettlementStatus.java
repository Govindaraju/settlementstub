package com.gimpact.settlement.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents the status of a settlement")
public enum SettlementStatus {
    
    @Schema(description = "The settlement is successful")
    SUCCESS("SUCCESS"),
    
    @Schema(description = "The settlement failed")
    FAILURE("FAILURE"),
    
    @Schema(description = "The settlement is pending")
    PENDING("PENDING");

    private final String value;

    SettlementStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
