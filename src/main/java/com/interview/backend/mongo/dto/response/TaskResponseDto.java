package com.interview.backend.mongo.dto.response;

public record TaskResponseDto(
    String id,
    String tittle,
    String text,
    String author,
    String assigned,
    Boolean completed
) {}