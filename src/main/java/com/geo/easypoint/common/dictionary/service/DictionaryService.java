package com.geo.easypoint.common.dictionary.service;

import com.geo.easypoint.common.dictionary.domain.Dictionary;
import com.geo.easypoint.common.dictionary.domain.DictionaryRepository;
import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import com.geo.easypoint.common.dictionary.web.DictionaryDto;
import com.geo.easypoint.common.dictionary.web.DictionaryUpdateDto;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.PartialUpdater;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class DictionaryService<E extends Dictionary, D extends DictionaryDto, C extends DictionaryCreateDto, U extends DictionaryUpdateDto> {
    private final DictionaryRepository<E> dictionaryRepository;
    private final DictionaryMapper<E, D, C> mapper;

    @Transactional(readOnly = true)
    public List<D> findAll() {
        return dictionaryRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public D create(C createRequest) {
        if (dictionaryRepository.existsByName(createRequest.getName())) {
            throw new EasyPointLogicException("Dictionary with name: " + createRequest.getName() + " already exists");
        }
        E savedEntity = dictionaryRepository.saveAndFlush(mapper.toEntity(createRequest));
        return mapper.toDto(savedEntity);
    }

    @Transactional
    public D update(U updateRequest, Long id) {
        E dictionary = findById(id);
        PartialUpdater.updater()
                .update(updateRequest.getName(), name -> {
                    validateName(name, id);
                    dictionary.setName(name);
                })
                .update(updateRequest.getDescription(), dictionary::setDescription);
        updateExtraProperties(updateRequest, dictionary);
        return mapper.toDto(dictionaryRepository.save(dictionary));
    }

    @Transactional
    public void delete(Long id) {
        dictionaryRepository.delete(findById(id));
    }

    private void validateName(String name, Long id) {
        if (dictionaryRepository.existsByNameAndIdNot(name, id)) {
            throw new EasyPointLogicException("Tool state with name " + name + " already exists");
        }
    }

    private E findById(Long id) {
        return dictionaryRepository.findById(id)
                .orElseThrow(() -> new EasyPointNotFoundException(id));
    }

    protected void updateExtraProperties(U updateRequest, E dictionary) {
    }
}
