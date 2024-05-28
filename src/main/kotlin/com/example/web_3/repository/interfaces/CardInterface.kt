package com.example.web_3.repository.interfaces

import com.example.web_3.repository.models.Card

interface CardService {
    fun getCardById(cardId: Long): Card?
    fun getAllCards(): List<Card>
}
