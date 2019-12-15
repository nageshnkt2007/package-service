package com.shop.backend.controller;

import com.shop.backend.exception.PackageServiceException;
import com.shop.backend.model.ShopPackage;
import com.shop.backend.service.CurrencyService;
import com.shop.backend.util.PackageUtil;
import com.shop.backend.dto.PackageDto;
import com.shop.backend.service.PackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PackageController for exposing rest end points
 * for performing CRUD operations for package.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/package", produces = MediaType.APPLICATION_JSON_VALUE)
public class PackageController {

    /**
     * Logger object to log events of this application .
     */
    public static final Logger LOG = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{packageId}")
    public ResponseEntity<?> getPackage(@PathVariable Long packageId, @RequestParam(value = "currency",required = false) String currency) throws PackageServiceException {
        ShopPackage shopPackage = packageService.getPackage(packageId);
        PackageDto shopPackageDto = PackageUtil.covertToPackageDto(shopPackage);
        shopPackageDto = PackageUtil.getSumForProducts(shopPackageDto, currencyService.getCurrencyFactor(currency));
        return ResponseEntity.status(HttpStatus.OK).body(shopPackageDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPackage(@RequestParam PackageDto packageDto) {
        Boolean isCreatePackageSuccess = packageService.
                createPackage(PackageUtil.covertToPackage(packageDto));
        return ResponseEntity.status(HttpStatus.OK).body(isCreatePackageSuccess);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePackage(@RequestParam("packageDto") PackageDto packageDto) throws PackageServiceException {
        ShopPackage shopPackage = packageService.getPackage(packageDto.getId());
        shopPackage = PackageUtil.updateShopPackageValues(shopPackage, packageDto);
        Boolean isUpdatePackageSuccess = packageService.updatePackage(shopPackage);
        return ResponseEntity.status(HttpStatus.OK).body(isUpdatePackageSuccess);
    }

    @DeleteMapping("/delete/{packageId}")
    public ResponseEntity<?> deletePackage(@PathVariable Long packageId) throws PackageServiceException {
        Boolean isDeletedSuccess = packageService.deletePackage(packageId);
        return ResponseEntity.status(HttpStatus.OK).body(isDeletedSuccess);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getPackages(@RequestParam(value = "currency",required = false) String currency) {
        LOG.info("method getPackages for getting all packages");
        List<ShopPackage> packages = packageService.getPackages();
        List<PackageDto> packageDtos = PackageUtil.convertToPackageDtoList(packages);
        packageDtos = PackageUtil.calculateTotalCost(packageDtos , currencyService.getCurrencyFactor(currency));
        return ResponseEntity.status(HttpStatus.OK).body(packageDtos);
    }
}
