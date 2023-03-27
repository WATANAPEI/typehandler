package dev.wpei.typehandler.entity;

import dev.wpei.typehandler.domain.Representative;
import dev.wpei.typehandler.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Insert("""
            INSERT into store 
            (request_id
            , store_name
            , brand_name
            , representative)
            VALUES 
            (#{requestId}
            , #{storeName}
            , #{brandName}
            , #{representatives, typeHandler=RepresentativeTypeHandler})
            """)
    void insert(String requestId, String storeName, String brandName, List<Representative> representatives);

    @ResultMap("storeResultMap")
    @Select("""
            SELECT
              id,
              request_id,
              store_name,
              brand_name,
              representative
            FROM store;
            """)
    List<Store> all();
}
