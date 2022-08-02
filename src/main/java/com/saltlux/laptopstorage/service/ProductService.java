package com.saltlux.laptopstorage.service;

import com.saltlux.laptopstorage.dto.ProductDto;
import com.saltlux.laptopstorage.model.Brand;
import com.saltlux.laptopstorage.model.Product;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;
import com.saltlux.laptopstorage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.saltlux.laptopstorage.utils.DaoUtils.buildPageable;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public PagedResponse<ProductDto> getAll(int page, int size, String orderBy, String sortDirection) {
        Pageable pageable = buildPageable(page, size, orderBy, sortDirection);
        Page<Product> systemPage = repository.search(pageable);
        List<Product> systemList = systemPage.getContent();

        List<ProductDto> list = systemList
                .stream()
                .map(obj -> {
                    ProductDto response = new ProductDto();
                    response.setId(obj.getId());
                    response.setName(obj.getName());
                    response.setBuyPrice(obj.getBuyPrice());
                    response.setSellPrice(obj.getSellPrice());
                    response.setCount(obj.getCount());
                    return response;
                }).collect(Collectors.toList());
        return new PagedResponse<>(list, systemPage.getNumber(), systemPage.getSize(), systemPage.getTotalElements(),
                systemPage.getTotalPages(), systemPage.isLast());
    }

    @Override
    public ProductDto findById(Integer id) {
        Optional<Product> product= repository.findById(id);
        ProductDto proResponse=new ProductDto();
        if(product.isPresent()){
            proResponse.setId(product.get().getId());
            proResponse.setName(product.get().getName());
            proResponse.setBuyPrice(product.get().getBuyPrice());
            proResponse.setSellPrice(product.get().getSellPrice());
            proResponse.setCount(product.get().getCount());
            return proResponse;
        }
        return null;
    }
}
