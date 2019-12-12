package com.shop.backend.service.impl;

import com.shop.backend.exception.PackageServiceException;
import com.shop.backend.model.ShopPackage;
import com.shop.backend.repo.PackageRepository;
import com.shop.backend.service.PackageService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PackageServiceImplTest {

    @Mock
    private PackageRepository packageRepository;

    @InjectMocks
    private PackageService packageService = new PackageServiceImpl();

    private ShopPackage shopPackage;
    private List<ShopPackage> shopPackages = new ArrayList<>();
    private Long packageId = 1l;
    private String description = "This is a test package with a dummy description ";
    private String name = "package name is my package";

    @BeforeAll
    public void setup() {
        shopPackage = new ShopPackage();
        shopPackage.setId(packageId);
        shopPackage.setDescription(description);
        shopPackage.setName(name);
    }

    @DisplayName("Test getPackage method when an entry exists ")
    @Test
    void getPackage() throws PackageServiceException {
        when(packageRepository.findById(packageId)).thenReturn(Optional.ofNullable(shopPackage));
        ShopPackage aPackage = packageService.getPackage(packageId);
        assertEquals(aPackage.getId(), packageId);
    }

    @DisplayName("Get package doesn't exist in the DB ")
    @Test
    void getPackage_NoDataFound() throws PackageServiceException {
        when(packageRepository.findById(packageId)).thenReturn(Optional.empty());
        ShopPackage aPackage = packageService.getPackage(packageId);
        assertNull(aPackage);
    }

    @DisplayName("Create Package succcess")
    @Test
    void createPackage() {
        when(packageRepository.save(shopPackage)).thenReturn(shopPackage);
        Boolean ifPackageCreated = packageService.createPackage(shopPackage);
        assertEquals(Boolean.TRUE, ifPackageCreated);
    }

    @DisplayName("Create Package failed")
    @Test
    void createPackage_failed() {
        when(packageRepository.save(shopPackage)).thenReturn(null);
        Boolean ifPackageCreated = packageService.createPackage(shopPackage);
        assertEquals(Boolean.FALSE, ifPackageCreated);
    }

    @DisplayName("Update Package success ")
    @Test
    void updatePackage() {
        when(packageRepository.save(shopPackage)).thenReturn(shopPackage);
        Boolean ifPackageCreated = packageService.updatePackage(shopPackage);
        assertEquals(Boolean.TRUE, ifPackageCreated);
    }

    @DisplayName("Update Package failed ")
    @Test
    void updatePackage_failed() {
        when(packageRepository.save(shopPackage)).thenReturn(null);
        Boolean ifPackageCreated = packageService.updatePackage(shopPackage);
        assertEquals(Boolean.FALSE, ifPackageCreated);
    }

    @DisplayName("Test Delete package success ")
    @Test
    void deletePackage() throws PackageServiceException {
        doNothing().when(packageRepository).deleteById(packageId);
        Boolean isDeleted = packageService.deletePackage(packageId);
        assertEquals(Boolean.TRUE, isDeleted);
    }

    @DisplayName("Get All Packages existing in Database ")
    @Test
    void getPackages() {
        shopPackages.add(shopPackage);
        when(packageRepository.findAll()).thenReturn(shopPackages);
        List<ShopPackage> packagesExist = packageService.getPackages();
        assertEquals(packagesExist.size(), shopPackages.size());
    }
}
