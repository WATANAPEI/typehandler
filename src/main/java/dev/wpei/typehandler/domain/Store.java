package dev.wpei.typehandler.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("Store")
public class Store {
    @Getter
    @Setter
    private Long id;

    @Getter
    @NotNull
    private final String requestId;

    @Getter
    @Setter
    @NotNull
    private String storeName;

    @Getter
    @Setter
    @NotNull
    private String brandName;

    @Getter
    @Setter
    private List<Representative> representatives;

    public Store(Long id, String requestId, String storeName, String brandName, List<Representative> representatives) {
        this.id = id;
        this.requestId = requestId;
        this.storeName = storeName;
        this.brandName = brandName;
        this.representatives = representatives;
    }

}
