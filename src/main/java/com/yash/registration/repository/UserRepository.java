package com.yash.registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.yash.registration.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
