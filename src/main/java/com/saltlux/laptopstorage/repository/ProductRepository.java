package com.saltlux.laptopstorage.repository;

import com.saltlux.laptopstorage.dto.ProductDto;
import com.saltlux.laptopstorage.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from Product p")
    Page<Product> search(Pageable pageable);
}
