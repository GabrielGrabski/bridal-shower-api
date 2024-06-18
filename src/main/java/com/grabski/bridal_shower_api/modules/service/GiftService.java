package com.grabski.bridal_shower_api.modules.service;

import com.grabski.bridal_shower_api.modules.dto.GiftRequest;
import com.grabski.bridal_shower_api.modules.dto.GiftResponse;
import com.grabski.bridal_shower_api.modules.model.Gift;
import com.grabski.bridal_shower_api.modules.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.grabski.bridal_shower_api.modules.service.utils.GiftValidator.validateFullRequest;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository repository;

    public void bookGift(Integer id) {
        var gift = repository.findById(id).orElseThrow();
        gift.setBooked(!gift.isBooked());
        repository.save(gift);
    }

    public void save(GiftRequest request) {
        validateFullRequest(request);
        repository.save(
                Gift.builder()
                        .name(request.name())
                        .isBooked(request.isBooked())
                        .imageName(request.imageName())
                        .build()
        );
    }

    public Page<GiftResponse> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(gift -> new GiftResponse(gift.getId(), gift.getName(),
                        gift.isBooked(), gift.getImageName()));
    }

    public Page<GiftResponse> findAllByName(String name, Pageable pageable) {
        return repository
                .findByNameLike(name, pageable)
                .map(gift -> new GiftResponse(gift.getId(), gift.getName(),
                        gift.isBooked(), gift.getImageName()));
    }
}
