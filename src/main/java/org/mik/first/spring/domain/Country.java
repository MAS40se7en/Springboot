package org.mik.first.spring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "country")
@EqualsAndHashCode(callSuper = true)
public class Country extends AbstractEntity<Long> {
    @JsonProperty("CountryName")
    @Column(name = "name", unique = true, nullable = false)
    @Length(min=3, max = 20)
    private String name;

    @JsonProperty("CountrySign")
    @Column(name = "sign", unique = true, nullable = false)
    @Length(min = 1, max = 3)
    private String sign;

}
