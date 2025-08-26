package com.interview.backend.mongo.service.impl;

import com.interview.backend.mongo.dto.request.PersonRequestDto;
import com.interview.backend.mongo.dto.response.PersonResponseDto;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
    Optional<PersonResponseDto> getPersonById(String id);
    List<PersonResponseDto> getAllPersons();
    PersonResponseDto updatePerson(String id, PersonRequestDto personRequestDto);
    void deletePerson(String id);
}