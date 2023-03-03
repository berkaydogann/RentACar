package com.springExample.rentACar.business.concretes;

import com.springExample.rentACar.business.abstracts.ModelService;
import com.springExample.rentACar.business.request.CreateModelRequest;
import com.springExample.rentACar.business.responses.GetAllModelsResponse;
import com.springExample.rentACar.business.responses.GetByIdModelResponse;
import com.springExample.rentACar.core.utilities.mappers.ModelMapperService;
import com.springExample.rentACar.dataAccess.abstracts.ModelRepository;
import com.springExample.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public GetByIdModelResponse getByIdModel(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse response = this.modelMapperService.forResponse()
                .map(model, GetByIdModelResponse.class);
        return response;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
