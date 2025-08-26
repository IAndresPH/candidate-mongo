package com.interview.backend.mongo.dto.request;

public record TaskRequestDto(
    String tittle,
    String text,
    String author,
    String assigned
) {}