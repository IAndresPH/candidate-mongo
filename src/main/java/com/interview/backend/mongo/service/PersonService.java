package com.interview.backend.mongo.service;

import com.interview.backend.mongo.dto.request.PersonRequestDto;
import com.interview.backend.mongo.dto.response.PersonResponseDto;
import com.interview.backend.mongo.mapper.PersonMapper;
import com.interview.backend.mongo.repository.IPersonRepository;
import com.interview.backend.mongo.service.impl.IPersonService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    private final IPersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(IPersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        var person = personMapper.mapToEntity(personRequestDto);
        var savedPerson = personRepository.save(person);
        return personMapper.mapToDto(savedPerson);
    }

    @Override
    public Optional<PersonResponseDto> getPersonById(String id) {
        return personRepository.findById(id)
                .map(personMapper::mapToDto);
    }

    @Override
    public List<PersonResponseDto> getAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::mapToDto)
                .toList();
    }

    @Override
    public PersonResponseDto updatePerson(String id, PersonRequestDto personRequestDto) {
        return personRepository.findById(id)
                .map(existingPerson -> {
                    existingPerson.setFirstName(personRequestDto.firstName());
                    existingPerson.setLastName(personRequestDto.lastName());
                    existingPerson.setEmail(personRequestDto.email());
                    existingPerson.setPhone(personRequestDto.phone());
                    existingPerson.setAddress(personRequestDto.address());
                    var updatedPerson = personRepository.save(existingPerson);
                    return personMapper.mapToDto(updatedPerson);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}