package com.springExample.rentACar.webApi.controllers;

import com.springExample.rentACar.business.abstracts.BrandService;
import com.springExample.rentACar.business.request.CreateBrandRequest;
import com.springExample.rentACar.business.request.UpdateBrandRequest;
import com.springExample.rentACar.business.responses.GetAllBrandsResponse;
import com.springExample.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getByIdBrandResponse(@PathVariable int id) {
        return brandService.getByIdBrand(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}
