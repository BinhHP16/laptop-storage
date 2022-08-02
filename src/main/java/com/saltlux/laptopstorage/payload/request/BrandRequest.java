package com.saltlux.laptopstorage.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    private Integer id;

    @NotNull
    private String name;
}
