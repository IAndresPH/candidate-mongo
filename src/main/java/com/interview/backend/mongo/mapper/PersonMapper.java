package com.interview.backend.mongo.mapper;

import com.interview.backend.mongo.dto.request.PersonRequestDto;
import com.interview.backend.mongo.dto.response.PersonResponseDto;
import com.interview.backend.mongo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person mapToEntity(PersonRequestDto dto) {
        if(dto == null) return null;

        Person person = new Person();
        person.setFirstName(dto.firstName());
        person.setLastName(dto.lastName());
        person.setEmail(dto.email());
        person.setPhone(dto.phone());
        person.setAddress(dto.address());
        return person;
    }

    public PersonResponseDto mapToDto(Person person) {
        return new PersonResponseDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhone(),
                person.getAddress()
        );
    }
}