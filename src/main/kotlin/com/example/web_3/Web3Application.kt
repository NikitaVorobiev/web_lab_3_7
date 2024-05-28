package com.example.web_3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

/**
 * ЗАДАНИЕ:
 * 1. Перенести сервисы и модели из предыдущей работы (можно было бы дописывать туда контроллеры отсюда, но так не
 * удобно рассылать)
 * 2. Добавить шаблоны (templates) для страници тикетов
 * 3. Доработать MainController, добавить методы для вывода тикетов (подключить недостающие сервисы к MainController)
 *
 * 4. Доработать этот файл так, чтобы база данных в постгрес создавалась под проект автоматически. Для этого:
 *  а) Настроить подключение к бд в application.properties
 *  б) Унаследовать главный класс приложения от CommandLineRunner
 *  в) Добавить в класс @Autowired JdbcTemplate jdbcTemplate;
 *  г) Переопледелить метод run
 *  д) Сгенерировать в постгресе скрипт создания базы данных и включить его в переопределенный run
 */



@SpringBootApplication
class Web3Application : CommandLineRunner {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    override fun run(vararg args: String?) {
        // Ваш код для создания базы данных или выполнения других действий при запуске приложения
        // Например:
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS example_table (id SERIAL, name VARCHAR(255))")
    }
}

fun main(args: Array<String>) {
    runApplication<Web3Application>(*args)
}
