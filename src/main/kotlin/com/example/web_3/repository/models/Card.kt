package com.example.web_3.repository.models

/**
 * Модель карточки. Хранит данные, которые записаны в базу данных для каждой карточки.
 */
class Card {
    var cardId: Long? = null
    var description: String? = null
    var authorId: Long? = null
    var assigneeId: Long? = null
    var statusId: Long? = null

    override fun toString(): String {
        return "Card(cardId=$cardId, description=$description, authorId=$authorId, assigneeId=$assigneeId, statusId=$statusId)"
    }
}
