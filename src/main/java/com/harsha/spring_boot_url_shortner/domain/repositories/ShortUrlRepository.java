package com.harsha.spring_boot_url_shortner.domain.repositories;
import com.harsha.spring_boot_url_shortner.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long>{
    ShortUrl findByShortUrl(String shorturl);
}