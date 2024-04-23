package org.mik.first.spring.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = UserInfo.TABLE_NAME)
@Data
@NoArgsConstructor
@SuperBuilder
public class UserInfo extends AbstractEntity<Long>{
    public  static final String TABLE_NAME= "user_info";

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "user_name", nullable = false, length = 30, unique = true, updatable = false)
    private String userName;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "email", length = 40, unique = true, nullable = false)
    private String email;

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "roles")

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role-info", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_role")
    private List<String> roles;
}
