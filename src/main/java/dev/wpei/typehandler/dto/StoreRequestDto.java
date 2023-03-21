package dev.wpei.typehandler.dto;

import dev.wpei.typehandler.domain.Representative;
import lombok.*;

@Data
public class StoreRequestDto {
    final private String requestId;
    final private String storeName;
    final private String brandName;
    final private Representative representative;

}
