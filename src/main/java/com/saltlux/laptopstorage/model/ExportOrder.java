package com.saltlux.laptopstorage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saltlux.laptopstorage.model.detail.DetailExport;
import com.saltlux.laptopstorage.model.detail.DetailImport;
import com.saltlux.laptopstorage.model.role.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(
        value = {"createdate"},
        allowGetters = true
)
@Table(name = "export_orders")
public class ExportOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="totalcost")
    private Integer totalCost;

    @CreatedDate
    @Column(name = "createdate")
    private Instant createDate;

    @Column(name = "status")
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userExport;

    @OneToMany(mappedBy = "exportOrder")
    Set<DetailExport> detailExports;


}
