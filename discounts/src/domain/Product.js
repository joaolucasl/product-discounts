const camelCase = require('camelcase-keys');


class Product {
    constructor(params) {
        this.id = params.id
        this.externalId = params.externalId
        this.price = params.price
        this.title = params.title
        this.description = params.description
    }

    static fromDB(dbObject) {
        return new Product(camelCase(dbObject))
    }
}

module.exports = Product