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
@Table(name = "person")
public class Person extends Client {

    @Column(name = "personal_id", nullable = false, unique = true)
    @Length(min = 11, max = 11)
    private String personalId;

}
