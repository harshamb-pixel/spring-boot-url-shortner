package com.harsha.spring_boot_url_shortner.domain.services;

import com.harsha.spring_boot_url_shortner.domain.entities.ShortUrl;
import com.harsha.spring_boot_url_shortner.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlSevices {
    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlSevices(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public List<ShortUrl> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls();
    }
}
