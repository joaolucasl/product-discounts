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
    
                const discount = await discountRulesService.calculateDiscount(rules, { user: normalUser, product })
                
                expect(discount).toBe(0.1)
            })

            it('should honor MAX_DISCOUNT when set', async () => {
                const rules = [
                    rulesStub.rule70PercentDiscount,
                    rulesStub.ruleMaxDiscount15Percent
                ]

                const discount = await discountRulesService.calculateDiscount(rules, { user: normalUser, product })
                
                expect(discount).toBe(0.15)
            })

            it('should honor all DISCOUNT rules available', async () => {
                const rules = [
                    rulesStub.rule70PercentDiscount,
                    rulesStub.rule10PercentDiscount,
                    rulesStub.rule5PercentDiscount
                ]

                const discount = await discountRulesService.calculateDiscount(rules, { user: normalUser, product })
                
                expect(discount).toBe(0.85)
            })
        })

        describe('with an invalid ruleset', () => {
            it('should default to 0 discount', async () => {
                const rules = [
                    rulesStub.ruleWithException,
                ]

                const discount = await discountRulesService.calculateDiscount(rules, { user: normalUser, product: productsStub.xiaomi })
                
                expect(discount).toBe(0.0)
            })
        })
    })
})