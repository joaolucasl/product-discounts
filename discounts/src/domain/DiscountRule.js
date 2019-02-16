const camelCase = require('camelcase-keys');

class DiscountRule {
    constructor(params) {
        this.id = params.id
        this.externalId = params.externalId
        this.name = params.name
        this.rule = params.rule
        this.type = params.type
    }

    static fromDB(dbObject) {
        return new DiscountRule(camelCase(dbObject))
    }
}

module.exports = DiscountRule