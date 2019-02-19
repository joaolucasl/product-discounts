const Decimal = require('decimal.js')
const allSettled = require('p-settle')
const zipWith = require('@ramda/zipwith')

const UserRepository = require('../../infrastructure/repositories/userRepository')
const ProductRepository = require('../../infrastructure/repositories/productRepository')
const DiscountRulesRepository = require('../../infrastructure/repositories/discountRuleRepository')
const DiscountRulesService = require('../../application/services/discountRulesService')

const applyDiscountToProduct = (product, discountResult) => {
    if (discountResult.isRejected) return ({ discount: 0.0, amount: product.price })

    const discount = discountResult.value
    const price = new Decimal(product.price)
    const amount = Decimal.sub(price, Decimal.mul(price, discount))

    return { discount, amount }
}

const getDiscount = async (userId, productIds) => {
    const user = await UserRepository.findByExternalId(userId)
    const discountRules = await DiscountRulesRepository.findAll()
    const products = await ProductRepository.findByExternalIds(productIds)
    const willCalculatedDiscount = products.map(product => DiscountRulesService.calculateDiscount(discountRules, { user, product })) 
    const calculatedDiscounts = await allSettled(willCalculatedDiscount)
    
    return zipWith(applyDiscountToProduct, products, calculatedDiscounts)
}



module.exports = {
    getDiscount
}