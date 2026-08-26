package com.harsha.spring_boot_url_shortner.domain.exceptions;

public class ShortUrlNotFoundException extends RuntimeException {
    public ShortUrlNotFoundException(String message) {

      super(message);
    }
}
