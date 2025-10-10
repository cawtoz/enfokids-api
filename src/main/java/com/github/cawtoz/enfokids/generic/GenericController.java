package com.github.cawtoz.enfokids.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<
    T, ID, REQUEST, RESPONSE,
    MAPPER extends GenericMapper<T, REQUEST, RESPONSE>
> {

    @Autowired
    protected GenericService<T, ID> service;

    @Autowired
    protected MAPPER mapper;

    @GetMapping
    public ResponseEntity<List<RESPONSE>> getAll() {
        return ResponseEntity.ok(mapper.toResponseSet(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RESPONSE> getById(@PathVariable ID id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toResponse(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RESPONSE> create(@RequestBody REQUEST request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(service.save(mapper.toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RESPONSE> update(@PathVariable ID id, @RequestBody REQUEST request) {
        return service.findById(id)
                .map(existingEntity -> {
                    mapper.updateEntityFromRequest(request, existingEntity);
                    T updatedEntity = service.save(existingEntity);
                    RESPONSE response = mapper.toResponse(updatedEntity);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
