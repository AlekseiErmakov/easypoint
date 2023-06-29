package com.geo.easypoint.common.dictionary.service;

import com.geo.easypoint.common.dictionary.domain.Dictionary;
import com.geo.easypoint.common.dictionary.web.DictionaryCreateDto;
import com.geo.easypoint.common.dictionary.web.DictionaryDto;

public interface DictionaryMapper<E extends Dictionary, D extends DictionaryDto, C extends DictionaryCreateDto> {

    D toDto(E dictionary);

    E toEntity(C createDictionaryRequest);

}
