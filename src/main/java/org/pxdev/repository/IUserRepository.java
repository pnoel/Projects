package org.pxdev.repository;

import org.pxdev.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    @Override
    @RestResource( exported = false )
    void deleteById( Long aLong );
}
