package com.springExample.rentACar.business.abstracts;

import com.springExample.rentACar.business.request.CreateBrandRequest;
import com.springExample.rentACar.business.responses.GetAllBrandsResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest createBrandRequest);
}
