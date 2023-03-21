package dev.wpei.typehandler.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("Store")
public class Store {
    @Getter
    @Setter
    private Long id;

    @Getter
    private final String requestId;

    @Getter
    @Setter
    private String storeName;

    @Getter
    @Setter
    private String brandName;

    @Getter
    @Setter
    private Representative representative;

    public Store(Long id, String requestId, String storeName, String brandName, Representative representative) {
        this.id = id;
        this.requestId = requestId;
        this.storeName = storeName;
        this.brandName = brandName;
        this.representative = representative;
    }

}
