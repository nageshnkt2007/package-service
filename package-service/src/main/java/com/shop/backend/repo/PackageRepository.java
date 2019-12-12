package com.shop.backend.repo;

import com.shop.backend.model.ShopPackage;
import org.springframework.data.repository.CrudRepository;

public interface PackageRepository extends CrudRepository<ShopPackage, Long> {
}
