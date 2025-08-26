package com.interview.backend.mongo.dto.response;

public record PersonResponseDto(
    String id,
    String firstName,
    String lastName,
    String email,
    String phone,
    String address
) {}