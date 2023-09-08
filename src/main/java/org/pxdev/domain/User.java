package org.pxdev.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Users" )
public class User extends AbstractDomain {

    @OneToMany( mappedBy = "createdBy" )
    private Set<User> creators;

    @Id
    @Column( name = "USER_ID", nullable = false, updatable = false )
    @GeneratedValue( generator = "USERS_SEQ", strategy = GenerationType.SEQUENCE )
    @SequenceGenerator( allocationSize = 20, initialValue = 10, name = "UsersSequenceGenerator", sequenceName = "USERS_SEQ" )
    private Long id;

    @Column( name = "FIRSTNAME", nullable = false )
    private String firstName;

    @Column( name = "LASTNAME", nullable = false )
    private String lastName;

    @OneToMany( mappedBy = "modifiedBy" )
    private Set<User> modifiers;

    @Column( name = "PASSWORD", nullable = false )
    private String password;

    @OneToMany( mappedBy = "author" )
    private Set<Project> projects;

    @Column( name = "PSEUDO", nullable = false )
    private String pseudo;

    @Override
    public String toString() {
        return firstName + " " + lastName + " ( " + pseudo + " )";
    }
}
