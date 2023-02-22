package com.springExample.rentACar.business.abstracts;

import com.springExample.rentACar.business.request.CreateBrandRequest;
import com.springExample.rentACar.business.request.UpdateBrandRequest;
import com.springExample.rentACar.business.responses.GetAllBrandsResponse;
import com.springExample.rentACar.business.responses.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getByIdBrand(int id);
    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
