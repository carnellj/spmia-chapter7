package com.thoughtmechanix.authentication.repository;


import com.thoughtmechanix.authentication.model.OrganizationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUserRepository extends CrudRepository<OrganizationUser,String>  {
    public OrganizationUser findByUserName(String userName);
}
