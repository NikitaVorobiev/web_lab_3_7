package com.example.web_3

import com.example.web_3.repository.models.Person

object GlobalState {
    var currentPerson: Person = Person()
    var userId: Int? = null
}