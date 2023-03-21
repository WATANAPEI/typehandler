package dev.wpei.typehandler.entity;

import dev.wpei.typehandler.domain.Representative;
import dev.wpei.typehandler.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    void insert(String requestId, String storeName, String brandName, Representative representative);
    List<Store> all();
}
