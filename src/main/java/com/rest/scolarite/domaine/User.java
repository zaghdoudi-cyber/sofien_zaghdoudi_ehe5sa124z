package com.rest.scolarite.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
    private Long id;

    @JsonIgnore
    @Size(max = 120)
    @Column(name = "password", length = 120, nullable = false)
    @NotBlank(message = "password ne doit pas être null ou vide")
    private String password;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    @NotBlank(message = "email ne doit pas être null ou vide")
    private String email;

    @Size(max = 60)
    @NotBlank(message = "username ne doit pas être null ou vide")
    private String username;
}
