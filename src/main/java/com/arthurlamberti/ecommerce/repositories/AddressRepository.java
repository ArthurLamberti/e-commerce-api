package com.arthurlamberti.ecommerce.repositories;

import com.arthurlamberti.ecommerce.models.AddressJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressJPAEntity, String> {
}
