package dev.wpei.typehandler.repository;

import dev.wpei.typehandler.domain.Store;
import dev.wpei.typehandler.dto.StoreRequestDto;
import dev.wpei.typehandler.entity.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

    private final StoreMapper storeMapper;

    @Transactional
    public void save(StoreRequestDto dto) {
        storeMapper.insert(dto.getRequestId(), dto.getStoreName(), dto.getBrandName(), dto.getRepresentatives());
    }

    public List<Store> all() {
        return storeMapper.all();
    }
}
