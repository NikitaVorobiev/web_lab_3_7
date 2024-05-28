package com.example.web_3.repository.impls

import com.example.web_3.repository.interfaces.ProfileService
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl(private val jdbcTemplate: JdbcTemplate) : ProfileService {

    override fun getUser(login: String?, password: String?): Int {
        val sql = "select \"userId\" from \"Users\" where login = ? and password = ?"
        return jdbcTemplate.queryForObject(sql, Int::class.java, login, password) ?: -1
    }
}
