package com.test1.repository;

import com.test1.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tliu on 12/8/16.*
 */

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

}
