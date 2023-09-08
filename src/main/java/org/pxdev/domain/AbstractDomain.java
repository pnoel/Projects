package org.pxdev.domain;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractDomain implements Serializable {
    @JoinColumn( name = "CREATED_BY", nullable = false, referencedColumnName = "USER_ID", updatable = false )
    @ManyToOne
    private User createdBy;

    @Column( name = "CREATED_DATE", nullable = false, updatable = false )
    private Date createdDate;

    @JoinColumn( name = "MODIFIED_BY", nullable = false, referencedColumnName = "USER_ID" )
    @ManyToOne
    private User modifiedBy;

    @Column( name = "MODIFIED_DATE", nullable = false )
    private Date modifiedDate;
}
