package com.harsha.spring_boot_url_shortner.domain.services;

import com.harsha.spring_boot_url_shortner.domain.models.ShortUrlDto;
import com.harsha.spring_boot_url_shortner.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlServices {

    private final ShortUrlRepository shortUrlRepository;
    private final EntityMapper entityMapper;

    public ShortUrlServices(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.entityMapper = entityMapper;
    }

    public List<ShortUrlDto> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls()
                .stream().map(entityMapper::toShortUrlDto).toList();
    }
}