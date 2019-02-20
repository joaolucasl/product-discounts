const DiscountRule = require('../../src/domain/DiscountRule')

const rule10PercentDiscount = new DiscountRule({
    id: 1,
    externalId: "RUL-AAAAAAAAAAAA",
    name: "John",
    rule: "percentage = 0.1",
    type: 'DISCOUNT'
})

const rule5PercentDiscount = new DiscountRule({
    id: 1,
    externalId: "RUL-BBBBBBBBBBBB",
    name: "John",
    rule: "percentage = 0.05",
    type: 'DISCOUNT'
})

const ruleMaxDiscount15Percent = new DiscountRule({
    id: 1,
    externalId: "RUL-CCCCCCCCCCCC",
    name: "John",
    rule: "percentage = 0.15",
    type: 'MAX_DISCOUNT'
})

const rule70PercentDiscount = new DiscountRule({
    id: 1,
    externalId: "RUL-DDDDDDDDDDDD",
    name: "John",
    rule: "percentage = 0.70",
    type: 'DISCOUNT'
})

const ruleWithException = new DiscountRule({
    id: 1,
    externalId: "RUL-DDDDDDDDDDDD",
    name: "John",
    rule: "throw 'BANG!'",
    type: 'DISCOUNT'
})


module.exports = {
    rule10PercentDiscount,
    rule5PercentDiscount,
    rule70PercentDiscount,
    ruleMaxDiscount15Percent,
    ruleWithException
}