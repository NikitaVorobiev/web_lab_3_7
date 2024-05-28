package com.example.web_3.controllers

import com.example.web_3.GlobalState
import com.example.web_3.SpringContext
import com.example.web_3.repository.models.Person
import com.example.web_3.repository.models.Card
import com.example.web_3.repository.interfaces.ProfileService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.DigestUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

/**
 * Контроллер приложения
 */
@Controller
class MainController {

    /**
     * Страница ошибки
     */
    @GetMapping("/error")
    fun error(model: Model): String? {
        model.addAttribute("person", Person())
        return "error"
    }
    @GetMapping("/")
    fun page(): String? {
        return "page"
    }

    /**
     * Страница авторизации
     */

    @GetMapping("/card")
    fun tickets(model: Model): String? {
        model.addAttribute("card", Card())
        return "card"
    }

    /**
     * Авторизация пользователя
     *
     * @param person заполненный пользователь
     * @return страницу тикетов в случае успеха, либо страница ошибки в случае неудачи
     */
    @GetMapping("/login")
    fun showLoginForm(model: Model): String {
        model.addAttribute("person", Person())
        return "login"
    }

    @PostMapping("/login")
    fun login(
            @ModelAttribute("person") person: Person,
            @RequestParam(required = false) redirect: String?,
            redirectAttributes: RedirectAttributes
    ): String {
        // Выполнить логику авторизации
        val isAuthenticationSuccessful = isValidUser(person)

        return if (isAuthenticationSuccessful) {
            if (redirect != null && redirect.isNotEmpty()) {
                redirectAttributes.addAttribute("param1", "value1")
                "redirect:/$redirect"
            } else {
                "redirect:/card"
            }
        } else {
            "login"
        }
    }

    private fun isValidUser(person: Person): Boolean {
        // Здесь должна находится ваша логика проверки пользователя
        return person.login == "admin" && person.password == "password"
    }
}
