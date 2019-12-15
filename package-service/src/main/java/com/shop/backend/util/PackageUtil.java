package com.shop.backend.util;

import com.shop.backend.dto.PackageDto;
import com.shop.backend.dto.ProductDto;
import com.shop.backend.model.Product;
import com.shop.backend.model.ShopPackage;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class PackageUtil {
    public static PackageDto covertToPackageDto(ShopPackage shopPackage) {
        return Objects.nonNull(shopPackage) ? new ModelMapper().map(shopPackage, PackageDto.class) : null;
    }

    public static ShopPackage covertToPackage(PackageDto packageDto) {
        return Objects.nonNull(packageDto) ? new ModelMapper().map(packageDto, ShopPackage.class) : null;
    }

    public static List<PackageDto> convertToPackageDtoList(List<ShopPackage> packages) {
        List<PackageDto> packageDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(packages)) {
            packages.forEach(packge -> {
                packageDtos.add(covertToPackageDto(packge));
            });
        }
        return packageDtos;
    }

    public static ShopPackage updateShopPackageValues(ShopPackage shopPackage, PackageDto packageDto) {
        shopPackage.setName(packageDto.getName());
        shopPackage.setDescription(packageDto.getDescription());
        shopPackage.setProducts(getProductsFromProductDto(packageDto.getProducts()));
        return shopPackage;
    }

    private static List<Product> getProductsFromProductDto(List<ProductDto> products) {
        List<Product> productList = new ArrayList<>();
        products.forEach(p -> {
            productList.add(new ModelMapper().map(p, Product.class));
        });
        return productList;
    }

    public static List<PackageDto> calculateTotalCost(List<PackageDto> packageDtos, Float currencyRateInFloat) {
        List<PackageDto> packageDtoList = new ArrayList<>();
        packageDtos.forEach(pckDto -> {
            packageDtoList.add(getSumForProducts(pckDto, currencyRateInFloat));
        });
        return packageDtoList;
    }

    public static PackageDto getSumForProducts(PackageDto pckDto, Float currencyRateInFloat) {
        List<Integer> prices = pckDto.getProducts().stream().map(ProductDto::getBasePrice).collect(Collectors.toList());
        float sum = prices.stream().mapToInt(Integer::intValue).sum();
        pckDto.setTotalPrice(sum* currencyRateInFloat);
        return pckDto;
    }
}
