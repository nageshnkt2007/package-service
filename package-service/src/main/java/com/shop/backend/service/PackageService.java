package com.shop.backend.service;

import com.shop.backend.exception.PackageServiceException;
import com.shop.backend.model.ShopPackage;

import java.util.List;

/**
 * This interface provides methods to handle shop packages .
 */
public interface PackageService {

    /**
     * @param packageId .
     * @return flag if a package was deleted .
     */
    ShopPackage getPackage(Long packageId) throws PackageServiceException;

    /**
     * @param shopPackage .
     * @return flag if a package was created .
     */
    Boolean createPackage(ShopPackage shopPackage);

    /**
     * @param shopPackage .
     * @return flag if a package was updated .
     */
    Boolean updatePackage(ShopPackage shopPackage);

    /**
     * @param packageId .
     * @return flag if a package was deleted .
     */
    Boolean deletePackage(Long packageId) throws PackageServiceException;

    /**
     * @return List All of packages .
     */
    List<ShopPackage> getPackages();

}
