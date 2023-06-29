package com.geo.easypoint.common.dictionary.web;

import com.geo.easypoint.common.dictionary.domain.Dictionary;
import com.geo.easypoint.common.dictionary.service.DictionaryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public abstract class DictionaryController<E extends Dictionary, D extends DictionaryDto, C extends DictionaryCreateDto, U extends DictionaryUpdateDto> {
    private final DictionaryService<E, D, C, U> service;

    @PostMapping
    public D create(@RequestBody @Valid C request) {
        return service.create(request);
    }

    @PatchMapping("/{id}")
    public D update(@RequestBody U request,
                    @Positive @PathVariable(name = "id") Long id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<D> findAll() {
        return service.findAll();
    }
}
