package com.saltlux.laptopstorage.model.detail;

import com.saltlux.laptopstorage.model.ExportOrder;
import com.saltlux.laptopstorage.model.ImportOrder;
import com.saltlux.laptopstorage.model.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "detail_export_orders")
public class DetailExport {
    @EmbeddedId
    DetailExportKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private ExportOrder exportOrder;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productDetailExport;

    @Column(name = "sellprice")
    private Integer sellPrice;

    @Column(name = "count")
    private Integer count;

    @Column(name = "totalcost")
    private Integer totalCost;
}
