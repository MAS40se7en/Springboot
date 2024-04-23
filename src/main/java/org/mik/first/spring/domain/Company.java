package org.mik.first.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "company")
public class Company extends Client {

    @Column(name = "tax_id", unique = true, nullable = false)
    @Length(min = 9, max = 9)
    private String taxId;
}
