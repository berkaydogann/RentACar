package com.springExample.rentACar.business.concretes;

import com.springExample.rentACar.business.abstracts.BrandService;
import com.springExample.rentACar.business.request.CreateBrandRequest;
import com.springExample.rentACar.business.request.UpdateBrandRequest;
import com.springExample.rentACar.business.responses.GetAllBrandsResponse;
import com.springExample.rentACar.business.responses.GetByIdBrandResponse;
import com.springExample.rentACar.business.rules.BrandBusinessRules;
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
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getByIdBrand(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
