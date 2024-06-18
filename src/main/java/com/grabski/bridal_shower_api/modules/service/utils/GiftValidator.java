package com.grabski.bridal_shower_api.modules.service.utils;

import com.grabski.bridal_shower_api.config.exception.model.ValidationException;
import com.grabski.bridal_shower_api.modules.dto.GiftRequest;

public class GiftValidator {

    private GiftValidator() {

    }

    public static void validateFullRequest(GiftRequest request) {
        validateRequestImageNameNull(request);
        validateRequestNameNull(request);
    }

    private static void validateRequestNameNull(GiftRequest request) {
        if (request.name() == null || request.name().isBlank()) {
            throw new ValidationException("Name cannot be null or empty.");
        }
    }

    private static void validateRequestImageNameNull(GiftRequest request) {
        if (request.imageName() == null || request.imageName().isBlank()) {
            throw new ValidationException("Image Name cannot be null or empty.");
        }
    }
}
