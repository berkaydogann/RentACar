package com.springExample.rentACar.business.abstracts;

import com.springExample.rentACar.business.request.CreateModelRequest;
import com.springExample.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
