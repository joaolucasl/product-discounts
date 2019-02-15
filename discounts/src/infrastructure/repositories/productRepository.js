const { db } = require('../database')
const ProductModel = require('../../domain/Product')

const findByExternalId = async (id) => {
    const product = await db.select().from('products').where({ external_id: id }).first()

    return new ProductModel(product)
}

module.exports = {
  findByExternalId
}