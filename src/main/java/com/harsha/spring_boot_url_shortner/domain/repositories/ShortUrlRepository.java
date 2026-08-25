package com.harsha.spring_boot_url_shortner.domain.repositories;
import com.harsha.spring_boot_url_shortner.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long>{
    ShortUrl findByShortKey(String shortKey);

    @Query("select su from ShortUrl su where su.isPrivate = false order by su.createdAt desc")
    List<ShortUrl> findPublicShortUrls();
}