const { normalUser } = require('../stubs/userStub')
const productsStub = require('../stubs/productStub')
const rulesStub = require('../stubs/discountRuleStub')
const discountRulesService = require('../../src/application/services/discountRulesService')

describe('calculateDiscount', () => {
    describe('with valid users and product', () => {
        describe('with a valid ruleset', () => {
            const product = productsStub.xiaomi

            it('should calculate properly the discount', async () => {
                const rules = [
                    rulesStub.rule10PercentDiscount,
                ]
    
                const discount = await discountRulesService.calculateDiscount(rules, { normalUser, product })
                
                expect(discount).toBe(0.1)
            })

            it('should honor MAX_DISCOUNT when set', async () => {
                const rules = [
                    rulesStub.rule70PercentDiscount,
                    rulesStub.ruleMaxDiscount15Percent
                ]

                const discount = await discountRulesService.calculateDiscount(rules, { normalUser, product })
                
                expect(discount).toBe(0.15)
            })
        })
    })
})