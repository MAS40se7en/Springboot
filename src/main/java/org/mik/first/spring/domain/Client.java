package org.mik.first.spring.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends AbstractEntity<Long> {

    @Column(name = "name", unique = false)
    @Length(min = 2, max = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country")
    private Country country;

}
