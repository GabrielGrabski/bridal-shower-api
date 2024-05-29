package com.grabski.bridal_shower_api.modules.controller;

import com.grabski.bridal_shower_api.modules.dto.GiftRequest;
import com.grabski.bridal_shower_api.modules.dto.GiftResponse;
import com.grabski.bridal_shower_api.modules.service.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/gifts")
public class GiftController {

    private final GiftService service;

    @PostMapping
    public void save(@RequestBody GiftRequest request) {
        service.save(request);
    }

    @PutMapping("{id}")
    public void bookGift(@PathVariable Integer id) {
        service.bookGift(id);
    }

    @GetMapping
    public Page<GiftResponse> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{name}")
    public Page<GiftResponse> findAllByName(@PathVariable("name") String name, Pageable pageable) {
        return service.findAllByName(name, pageable);
    }
}
