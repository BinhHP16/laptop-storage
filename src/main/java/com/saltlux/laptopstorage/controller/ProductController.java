package com.saltlux.laptopstorage.controller;

import com.saltlux.laptopstorage.dto.ProductDto;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;
import com.saltlux.laptopstorage.service.IProductService;
import com.saltlux.laptopstorage.utils.constraints.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public PagedResponse<ProductDto> getAll(@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                            @RequestParam(value = "sortDirection", defaultValue = "desc") String sortDirection,
                                            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return productService.getAll(page, size, orderBy, sortDirection);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Integer id) {
        ProductDto response = productService.findById(id);
        if (Objects.nonNull(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
