package org.mik.first.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = RoleInfo.TABLE_NAME)
@Data
@NoArgsConstructor
@SuperBuilder
public class RoleInfo extends AbstractEntity<Long>{
    public static final String TABLE_NAME = "role_info";

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
