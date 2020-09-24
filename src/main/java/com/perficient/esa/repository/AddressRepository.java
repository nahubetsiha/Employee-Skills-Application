package com.perficient.esa.repository;

import com.perficient.esa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Long, Address> {
}