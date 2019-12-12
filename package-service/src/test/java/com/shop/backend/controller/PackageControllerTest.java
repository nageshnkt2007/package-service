package com.shop.backend.controller;

import com.shop.backend.dto.PackageDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageControllerTest {


    private static final String APPLICATION_PORT = "8888";
    private static final String BASE_URL = "http://localhost:" + APPLICATION_PORT + "/package/";
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @DisplayName("Integration test of get package success")
    @Test
    public void testGetPackage_By_ID(){
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(BASE_URL+ "get" + "/4", PackageDto.class);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        PackageDto packageDto = (PackageDto) responseEntity.getBody();
        assertNotNull(packageDto.getDescription());
    }

    @DisplayName("Integration test of get package failed")
    @Test
    public void testGetPackage_By_ID_fail(){
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(BASE_URL+ "get" + "/1", PackageDto.class);
        assertEquals(HttpStatus.NO_CONTENT,responseEntity.getStatusCode());
    }

    @DisplayName("Integration test of get all packages success")
    @Test
    public void testGetAllPackages(){
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(BASE_URL+ "all", PackageDto[].class);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        PackageDto[] packageDtos = (PackageDto[]) responseEntity.getBody();
        assertNotNull(packageDtos);
        assertEquals(true, packageDtos.length>0);
    }


}
