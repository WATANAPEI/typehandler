package dev.wpei.typehandler.dto;

import lombok.Data;

@Data
public class StoreResponse {
    final private String requestId;
    final private ResultCode resultCode;
    final private String resultMessage;
}
