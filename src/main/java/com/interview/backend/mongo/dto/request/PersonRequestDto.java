package com.interview.backend.mongo.dto.request;

public record PersonRequestDto(
    String firstName,
    String lastName,
    String email,
    String phone,
    String address
) {}