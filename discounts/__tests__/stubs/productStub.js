const Product = require('../../src/domain/Product')

const xiaomi = new Product({
    id: 1,
    externalId: "PRO-AAAAAAAAAAAA",
    price: 200000,
    title: "Xiaomi Mi 8",
    description: "An underpriced phone with a fanbase"
})

const iPhone = new Product({
    id: 1,
    externalId: "PRO-BBBBBBBBBBBB",
    price: 200000,
    title: "iPhone 8",
    description: "An overpriced phone with a fanbase"
})

module.exports = {
    xiaomi,
    iPhone
}