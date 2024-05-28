package com.grabski.bridal_shower_api.modules.repository;

import com.grabski.bridal_shower_api.modules.model.Gift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Integer> {

    @Query(value = "SELECT * FROM gift WHERE name LIKE %:name%", nativeQuery = true)
    Page<Gift> findByNameLike(@Param("name") String name, Pageable pageable);
}
