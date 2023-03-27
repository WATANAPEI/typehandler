package dev.wpei.typehandler.dto;

import dev.wpei.typehandler.domain.Representative;
import lombok.*;

import java.util.List;

@Data
public class StoreRequestDto {
    final private String requestId;
    final private String storeName;
    final private String brandName;
    final private List<Representative> representatives;

}
