const sinon = require('sinon')
const mockRequire = require('mock-require')
mockRequire('../../../src/infrastructure/database', {
    db: {}
})

const facade = require('../../../src/interface/facade/discountFacade') 
const UserRepository = require('../../../src/infrastructure/repositories/userRepository')
const ProductRepository = require('../../../src/infrastructure/repositories/productRepository')
const DiscountRulesRepository = require('../../../src/infrastructure/repositories/discountRuleRepository')
const DiscountRulesService = require('../../../src/application/services/discountRulesService')
const usersStub = require('../../stubs/userStub')
const productStub = require('../../stubs/productStub')
const discountRulesStub = require('../../stubs/discountRuleStub')


describe('DiscountFacade', () => {
    describe('getDiscount', () => {
        beforeAll(() => {
            sinon.stub(UserRepository, 'findByExternalId').returns(usersStub.normalUser)

            sinon.stub(DiscountRulesRepository, 'findAll').returns([
                discountRulesStub.rule10PercentDiscount,
                discountRulesStub.rule5PercentDiscount
            ])

            sinon.stub(ProductRepository, 'findByExternalIds').returns([
                productStub.iPhone,
                productStub.xiaomi
            ])

            sinon.spy(DiscountRulesService, 'calculateDiscount')
        })

        it('shouldve called the mocked repositories', async () => {
            await facade.getDiscount(usersStub.normalUser.externalId, [
                productStub.iPhone.externalId,
                productStub.xiaomi.externalId
            ])

            expect(UserRepository.findByExternalId.called).toBe(true)
            expect(ProductRepository.findByExternalIds.called).toBe(true)
            expect(DiscountRulesRepository.findAll.called).toBe(true);
        })

        it('shouldve applied discounts to all products', async () => {
            const products = [
                productStub.iPhone,
                productStub.xiaomi
            ]

            const discounts = await facade.getDiscount(usersStub.normalUser.externalId, products.map(p => p.externalId))

            const areDiscountsRight = discounts.every((discount, index) => {
                const price = products[index].price
                const totalShouldBe = (price - (price * 0.15))
                return totalShouldBe == discount.amount
            })

            expect(areDiscountsRight).toBe(true)
        })
    })
})