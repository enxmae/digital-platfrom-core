package com.dvfu.digital_platform_core.dao;

import com.dvfu.digital_platform_core.constants.UserRoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="AUTHORITY")
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -6173672801831223096L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated( EnumType.STRING)
    UserRoleName authority;

    @Override
    public String getAuthority() {
        return authority.name();
    }

    public void setAuthority(UserRoleName name) {
        this.authority = name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
