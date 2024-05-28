package com.example.web_3.repository.impls

import com.example.web_3.repository.models.Card
import com.example.web_3.repository.interfaces.CardService
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service
import java.sql.ResultSet



@Service
class CardServiceImpl(private val jdbcTemplate: JdbcTemplate) : CardService {
    private val cardRowMapper = RowMapper<Card> { rs: ResultSet, _: Int ->
        Card().apply {
            cardId = rs.getLong("cardId")
            description = rs.getString("descriprion")
            authorId = rs.getLong("authorId")
            assigneeId = rs.getLong("assigneeId")
            statusId = rs.getLong("statusId")
        }
    }

    override fun getCardById(cardId: Long): Card? {
        val sql = "SELECT * FROM \"Cards\" WHERE \"cardId\" = ?"
        return jdbcTemplate.queryForObject(sql, cardRowMapper, cardId)
    }

    override fun getAllCards(): List<Card> {
        val sql = "SELECT * FROM \"Cards\""
        return jdbcTemplate.query(sql, cardRowMapper)
    }
}
