package com.saltlux.laptopstorage.service;

import com.saltlux.laptopstorage.model.Brand;
import com.saltlux.laptopstorage.payload.request.BrandRequest;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;
import com.saltlux.laptopstorage.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.saltlux.laptopstorage.utils.DaoUtils.buildPageable;
import static com.saltlux.laptopstorage.utils.ValidationUtil.isValidId;

@Service
@Slf4j
public class BrandService implements IBrandService{

    @Autowired
    BrandRepository repository;
    @Override
    public PagedResponse<BrandResponse> getAll(int page, int size, String orderBy, String sortDirection) {
        Pageable pageable = buildPageable(page, size, orderBy, sortDirection);
        Page<Brand> systemPage = repository.search(pageable);
        List<Brand> systemList = systemPage.getContent();

        List<BrandResponse> list = systemList
                .stream()
                .map(obj->{
                    BrandResponse response =new BrandResponse();
                    response.setId(obj.getId());
                    response.setName(obj.getName());
                return  response;
                }).collect(Collectors.toList());
        return new PagedResponse<>(list, systemPage.getNumber(), systemPage.getSize(), systemPage.getTotalElements(),
                systemPage.getTotalPages(), systemPage.isLast());
    }

    @Override
    public BrandResponse findById(Integer id) {
        Optional<Brand> brand= repository.findById(id);
       BrandResponse brandResponse=new BrandResponse();
       if(brand.isPresent()){
           brandResponse.setId(brand.get().getId());
           brandResponse.setName(brand.get().getName());
           return brandResponse;
       }
        return null;
    }

    @Override
    public BrandResponse save(BrandRequest request) throws MissingServletRequestParameterException {
        log.info("start save brand ");
        if (request == null) {
            throw new MissingServletRequestParameterException(null, null);
        }
        Integer id = request.getId();
        Brand brand = isValidId(id) ? repository.findById(id).get() : new Brand();
//        request.setStatus(AppConstants.STATUS_ACTIVE);
//        request.setCreatedDate(new java.util.Date());
//        request.setUpdatedDate(new java.util.Date());
        BeanUtils.copyProperties(request, brand);
        Brand brandResult=repository.save(brand);
        if(Objects.nonNull(brandResult))
        return new BrandResponse (brandResult.getId(),brandResult.getName());
        return null;
    }

    @Override
    public void delete(Integer id) {
        Brand brand =repository.findById(id).get();
        repository.delete(brand);
    }
}
