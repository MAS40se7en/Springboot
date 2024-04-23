package org.mik.first.spring.domain.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.mik.first.spring.domain.RoleInfo;

import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserDTO extends AbstractDTO {


    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private Boolean active;

    private String email;

    private Set<RoleDTO> roles;
}
