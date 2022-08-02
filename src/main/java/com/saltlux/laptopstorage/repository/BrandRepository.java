package com.saltlux.laptopstorage.repository;

import com.saltlux.laptopstorage.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    @Query("SELECT b from Brand b")
    Page<Brand> search(Pageable pageable);
}
