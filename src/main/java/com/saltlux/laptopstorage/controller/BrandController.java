package com.saltlux.laptopstorage.controller;

import com.saltlux.laptopstorage.payload.request.BrandRequest;
import com.saltlux.laptopstorage.payload.response.BrandResponse;
import com.saltlux.laptopstorage.payload.response.PagedResponse;
import com.saltlux.laptopstorage.service.IBrandService;
import com.saltlux.laptopstorage.utils.constraints.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    IBrandService brandService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public PagedResponse<BrandResponse> getAll(@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                               @RequestParam(value = "sortDirection", defaultValue = "desc") String sortDirection,
                                               @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                               @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return brandService.getAll(page, size, orderBy, sortDirection);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BrandResponse> getById(@PathVariable("id") Integer id) {
        BrandResponse response = brandService.findById(id);
        if (Objects.nonNull(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BrandResponse> saveOrUpdate(@Valid @RequestBody BrandRequest request) throws MissingServletRequestParameterException {
        if (request == null) {
            throw new MissingServletRequestParameterException(null, null);
        }
        BrandResponse response = brandService.save(request);
        if (Objects.nonNull(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
        brandService.delete(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }


}
