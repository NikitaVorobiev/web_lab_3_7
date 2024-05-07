package com.example.web_3.controllers

import com.example.web_3.models.Person
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.DigestUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.context.request.RequestContextHolder
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

    /**
     * Страница авторизации
     */
    @GetMapping("/login")
    fun welcome(model: Model): String? {
        model.addAttribute("person", Person())
        return "login"
    }

    /**
     * Авторизация пользователя
     *
     * @param person заполненный пользователь
     * @return страницу тикетов в случае успеха, либо страница ошибки в случае неудачи
     */
    @PostMapping("/login")
    fun login(@ModelAttribute("person") person: Person): String? {
        val userId: Int = profileRepository.getUser(
            person.getLogin(),
            DigestUtils.md5DigestAsHex(person.getPassword().getBytes()).uppercase(Locale.getDefault())
        )
        UserService.usersCache.put(RequestContextHolder.currentRequestAttributes().sessionId, userId)
        return if (userId > 0) "redirect:/tickets" else {
            "redirect:/error"
        }
    }
}