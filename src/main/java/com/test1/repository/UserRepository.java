package com.test1.repository;

import com.test1.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by tliu on 12/7/16.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
