package com.github.joaolucasl.chumlee.products.infrastructure.persistence.mapper

import com.github.joaolucasl.chumlee.products.domain.Product
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class ProductMapper : RowMapper<Product> {
    override fun map(rs: ResultSet?, ctx: StatementContext?): Product {
        return Product(
            id = rs!!.getInt("id"),
            externalId = rs.getString("external_id"),
            price = rs.getInt("price"),
            title = rs.getString("title"),
            description = rs.getString("description")
        )
    }
}