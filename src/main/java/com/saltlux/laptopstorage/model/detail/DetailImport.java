package com.saltlux.laptopstorage.model.detail;

import com.saltlux.laptopstorage.model.ImportOrder;
import com.saltlux.laptopstorage.model.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "detail_import_orders")
public class DetailImport {
    @EmbeddedId
    DetailImportKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private ImportOrder importOrder;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productDetailImport;

    @Column(name = "buyprice")
    private Integer buyPrice;

    @Column(name = "count")
    private Integer count;

    @Column(name = "totalcost")
    private Integer totalCost;

}
