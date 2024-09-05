package org.example.traveltour.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionConstants {
    TOUR_NOT_FOUND("TOUR_NOT_FOUND", "Tour not found"),
    GUIDE_NOT_FOUND("GUIDE_NOT_FOUND", "Guide not found"),
    ILLEGAL_EXCEPTION("ILLEGAL_EXCEPTION", "Illegal exception"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception happens");
    private String code;
    private String message;

}
