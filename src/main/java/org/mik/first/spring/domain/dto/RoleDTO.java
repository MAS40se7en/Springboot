package org.mik.first.spring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@SuperBuilder
public class RoleDTO extends AbstractDTO {
    private String name;
}
