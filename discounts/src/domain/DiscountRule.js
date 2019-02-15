class DiscountRule {
    constructor(params) {
        this.id = params.id
        this.external_id = params.external_id
        this.name = params.name
        this.rule = params.rule
        this.type = params.type
    }
}

module.exports = DiscountRule