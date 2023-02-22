package com.springExample.rentACar.business.concretes;

import com.springExample.rentACar.business.abstracts.BrandService;
import com.springExample.rentACar.business.request.CreateBrandRequest;
import com.springExample.rentACar.business.responses.GetAllBrandsResponse;
import com.springExample.rentACar.core.utilities.mappers.ModelMapperService;
import com.springExample.rentACar.dataAccess.abstracts.BrandRepository;
import com.springExample.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Business Object
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> this.modelMapperService.forRespone().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
}
