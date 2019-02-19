const { db } = require('../database')
const ProductModel = require('../../domain/Product')

const findByExternalId = async (id) => {
    const product = await db.select().from('products').where({ external_id: id }).first()

    return ProductModel.fromDB(product)
}

const findByExternalIds = async (idList) => {
  const products = await db.select().from('products').whereIn('external_id', idList)

  return products.map(prod => ProductModel.fromDB(prod))
}

module.exports = {
  findByExternalId,
  findByExternalIds
}