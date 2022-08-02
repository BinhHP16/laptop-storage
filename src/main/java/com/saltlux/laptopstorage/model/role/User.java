package com.saltlux.laptopstorage.model.role;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saltlux.laptopstorage.model.ExportOrder;
import com.saltlux.laptopstorage.model.ImportOrder;
import com.saltlux.laptopstorage.model.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "password")
        })
@JsonIgnoreProperties(
        value = {"create_date"},
        allowGetters = true
)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "path_image")
    private String pathImage;

    @CreatedDate
    @Column(name = "create_date")
    private Instant createDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy="userImport")
    private Set<ImportOrder> importOrders;

    @OneToMany(mappedBy="userExport")
    private Set<ExportOrder> exportOrders;


    public User(String username,String fullName, String email, String password) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
