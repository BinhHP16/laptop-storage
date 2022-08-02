package com.saltlux.laptopstorage.service;

import com.saltlux.laptopstorage.payload.request.BrandRequest;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Optional;

public interface IBrandService {
    PagedResponse<BrandResponse> getAll(int page, int size, String orderBy, String sortDirection);

    BrandResponse findById(Integer id);

    BrandResponse save(BrandRequest request) throws MissingServletRequestParameterException;

    void delete(Integer id);
}
