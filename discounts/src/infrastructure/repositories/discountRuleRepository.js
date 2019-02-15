const { db } = require('../database')
const DiscountRuleModel = require('../../domain/DiscountRule.js')

const findAll = async () => {
    const rules = await db.select().from('discount_rules')

    return rules.map(r  => new DiscountRuleModel(r))
}

module.exports = {
  findAll
}