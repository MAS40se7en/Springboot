package org.mik.first.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public class AbstractEntity<ID extends Serializable> implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    @JsonIgnore
    @Version
    private Integer version;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime created;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updated;

}
