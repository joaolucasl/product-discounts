class Product {
    constructor(params) {
        this.id = params.id
        this.externalId = params.externalId
        this.price = params.price
        this.title = params.title
        this.description = params.description
    }
}

module.exports = Product