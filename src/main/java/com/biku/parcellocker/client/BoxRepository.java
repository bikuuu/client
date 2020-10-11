package com.biku.parcellocker.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {

}
