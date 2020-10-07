package com.yash.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.registration.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
