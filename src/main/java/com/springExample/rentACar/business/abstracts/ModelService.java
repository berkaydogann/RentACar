package com.springExample.rentACar.business.abstracts;

import com.springExample.rentACar.business.request.CreateModelRequest;
import com.springExample.rentACar.business.responses.GetAllModelsResponse;
import com.springExample.rentACar.business.responses.GetByIdModelResponse;


import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    GetByIdModelResponse getByIdModel(int id);

    void add(CreateModelRequest createModelRequest);
}
