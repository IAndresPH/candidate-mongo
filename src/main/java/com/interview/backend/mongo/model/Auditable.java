package com.interview.backend.mongo.model;

import java.time.LocalDateTime;

public abstract class Auditable {
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updateAt;
    private Boolean active = true;
}