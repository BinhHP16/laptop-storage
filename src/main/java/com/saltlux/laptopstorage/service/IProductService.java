package com.saltlux.laptopstorage.service;

import com.saltlux.laptopstorage.dto.ProductDto;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;

public interface IProductService {
    PagedResponse<ProductDto> getAll(int page, int size, String orderBy, String sortDirection);

    ProductDto findById(Integer id);
}
