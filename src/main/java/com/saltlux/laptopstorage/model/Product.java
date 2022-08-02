package com.saltlux.laptopstorage.model;

import com.saltlux.laptopstorage.model.detail.DetailExport;
import com.saltlux.laptopstorage.model.detail.DetailImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "buyprice")
    private Integer buyPrice;

    @Column(name = "sellprice")
    private Integer sellPrice;

    @Column(name = "count")
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "productDetailImport")
    Set<DetailImport> detailImports;

    @OneToMany(mappedBy = "productDetailExport")
    Set<DetailExport> detailexports;

}
