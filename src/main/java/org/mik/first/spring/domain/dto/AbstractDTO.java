package org.mik.first.spring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class AbstractDTO {
    private Long id;
}
