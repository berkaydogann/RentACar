package com.springExample.rentACar.webApi.controllers;

import com.springExample.rentACar.business.abstracts.ModelService;
import com.springExample.rentACar.business.request.CreateModelRequest;
import com.springExample.rentACar.business.responses.GetAllModelsResponse;
import com.springExample.rentACar.business.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdModelResponse getByModelResponse(@PathVariable int id) {
        return modelService.getByIdModel(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}
