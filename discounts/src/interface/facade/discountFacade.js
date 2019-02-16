const Decimal = require('decimal.js')

const UserRepository = require('../../infrastructure/repositories/userRepository')
const ProductRepository = require('../../infrastructure/repositories/productRepository')
const DiscountRulesRepository = require('../../infrastructure/repositories/discountRuleRepository')
const DiscountRulesService = require('../../application/services/discountRulesService')

const getDiscount = async (userId, productId) => {
    const user = await UserRepository.findByExternalId(userId)
    const discountRules = await DiscountRulesRepository.findAll()
    const product = await ProductRepository.findByExternalId(productId)

    const discount = await DiscountRulesService.calculateDiscount(discountRules, { user })

    const price = new Decimal(product.price)
    const amount = Decimal.sub(price, Decimal.mul(price, discount))

    return ({ 
        discount,
        amount
    })
}

module.exports = {
    getDiscount
}