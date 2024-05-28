//package com.example.web_3
//
//import com.example.web_3.models.PersonInfo
//import com.example.web_3.repository.interfaces.CardService
//import com.example.web_3.repository.interfaces.ProfileService
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication
//
//@SpringBootApplication
//class JdbcApplication
//
//fun main(args: Array<String>) {
//    runApplication<JdbcApplication>(*args)
//
//    // Создаем пустого персона и сохраняем в глобальную переменную
//    GlobalState.currentPerson = PersonInfo()
//
//    // Авторизация и логин пользователя
//    authorise(GlobalState.currentPerson)
//    login(GlobalState.currentPerson)
//
//    // Вывод информации о пользователе
//    println("Login: ${GlobalState.currentPerson.login}")
//    println("User ID: ${GlobalState.userId}")
//
//    // Вывод списка всех карточек
//    val cardService: CardService = SpringContext.getBean(CardService::class.java)
//    val allCards = cardService.getAllCards()
//    println("Cards:")
//    allCards.forEach { println(it) }
//}
//
//fun login(person: PersonInfo) {
//    // Получаем экземпляр ProfileService из контекста Spring
//    val profileService: ProfileService = SpringContext.getBean(ProfileService::class.java)
//    GlobalState.userId = profileService.getUser(person.login, person.password)
//}
//
//fun authorise(person: PersonInfo) {
//    person.login = "testlogin"
//    person.password = "12345"
//}
