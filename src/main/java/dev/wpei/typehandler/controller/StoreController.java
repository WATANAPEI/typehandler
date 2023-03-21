package dev.wpei.typehandler.controller;

import dev.wpei.typehandler.domain.Store;
import dev.wpei.typehandler.dto.ResultCode;
import dev.wpei.typehandler.dto.StoreRequestDto;
import dev.wpei.typehandler.dto.StoreResponse;
import dev.wpei.typehandler.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;

    @PostMapping("/store")
    public StoreResponse post(@RequestBody StoreRequestDto body) {
        storeRepository.save(body);
        return new StoreResponse(body.getRequestId(), ResultCode.SUCCESS, "");
    }

    @GetMapping("/stores")
    public List<Store> all() {
    List<Store> stores = storeRepository.all();
    return stores;
    }
}
