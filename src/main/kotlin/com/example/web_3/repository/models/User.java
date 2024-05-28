package com.example.web_3.repository.models;

import org.springframework.stereotype.Component;

/**
 * Модель для идентификации пользователя из БД
 *
 * @param id идентификатор
 */

public record User(
        int id
) {
}
