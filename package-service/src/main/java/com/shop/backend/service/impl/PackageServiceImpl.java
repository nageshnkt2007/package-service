package com.shop.backend.service.impl;

import com.shop.backend.exception.PackageServiceException;
import com.shop.backend.model.ShopPackage;
import com.shop.backend.repo.PackageRepository;
import com.shop.backend.service.PackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 * Package Service to handle all the CRUD operations,
 * Done on ShopPackage .
 */
@Service("packageService")
@Transactional
public class PackageServiceImpl implements PackageService {

    /**
     * Logger Object used for Logging .
     */
    public static final Logger LOG = LoggerFactory.getLogger(PackageServiceImpl.class);

    @Autowired
    private PackageRepository packageRepository;

    /**
     * @param packageId .
     * @return flag if a package was deleted .
     */
    @Override
    public ShopPackage getPackage(Long packageId) throws PackageServiceException {
        LOG.debug("method getPackage for packageId {}", packageId);
        ShopPackage shopPackage = null;
        try {
            Optional<ShopPackage> shopPackageOptional = packageRepository.findById(packageId);
            shopPackage = shopPackageOptional.get();
        } catch (NoSuchElementException | IllegalStateException exception) {
            LOG.error("Error occured while fetching package data for packageId {} {}", packageId ,exception.getMessage());
            throw new PackageServiceException("Data not found for this package id ");
        }
        return shopPackage;
    }

    /**
     * @param shopPackage .
     * @return flag if a package was created .
     */
    @Override
    public Boolean createPackage(ShopPackage shopPackage) {
        ShopPackage shopPackageSaved = packageRepository.save(shopPackage);
        return Objects.nonNull(shopPackageSaved) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * @param shopPackage .
     * @return flag if a package was updated .
     */
    @Override
    public Boolean updatePackage(ShopPackage shopPackage) {
        ShopPackage shopPackageSaved = packageRepository.save(shopPackage);
        return Objects.nonNull(shopPackageSaved) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * @param packageId .
     * @return flag if a package was deleted .
     */
    @Override
    public Boolean deletePackage(Long packageId) throws PackageServiceException {
        Boolean isDeleted = Boolean.FALSE;
        try {
            packageRepository.deleteById(packageId);
            isDeleted = Boolean.TRUE;
        } catch (EmptyResultDataAccessException exception) {
            LOG.error("Error occured while deleting package data by id {} ", packageId);
            throw new PackageServiceException("Error deleting this package", exception);
        }
        return isDeleted;
    }


    /**
     * @return List All of packages .
     */
    @Override
    public List<ShopPackage> getPackages() {
        LOG.info("getPackages Service call to fetch all packages");
        List<ShopPackage> shopPackages = (List<ShopPackage>) packageRepository.findAll();
        return shopPackages;
    }
}
