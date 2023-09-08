package org.pxdev.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table( name = "PROJECT", uniqueConstraints = {
        @UniqueConstraint( columnNames = "PROJECT_UUID", name = "UK_PROJECT_UUID" )
} )
public class Project extends AbstractDomain {

    @JoinColumn( foreignKey = @ForeignKey( name = "AUTHOR" ), name = "AUTHOR_ID", nullable = false, referencedColumnName = "USER_ID" )
    @ManyToOne
    private User author;

    @Column( name = "DESCRIPTION", length = Integer.MAX_VALUE )
    @Lob
    private String description;

    @Column( insertable = false, name = "PROJECT_ID", nullable = false, updatable = false )
    @Id
    @GeneratedValue( generator = "PROJECT_SEQ", strategy = GenerationType.SEQUENCE )
    @SequenceGenerator( allocationSize = 20, initialValue = 1, name = "ProjectSequenceGenerator", sequenceName = "PROJECT_SEQ" )
    private Long id;

    @Column( name = "NAME", nullable = false )
    private String name;

    @Column( length = 40, name = "PROJECT_UUID", nullable = false, updatable = false )
    private UUID projectUUID = UUID.randomUUID();

    @Override
    public String toString() {
        return name + "\n\t" + description.replace( "\n", "\n\t" );
    }
}
