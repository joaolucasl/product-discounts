const UserRepository = require('../../infrastructure/repositories/userRepository')
const DiscountRulesRepository = require('../../infrastructure/repositories/discountRuleRepository')
const DiscountRulesService = require('../../application/services/discountRulesService')

const getDiscount = async (userId, productId) => {
    const user = await UserRepository.findByExternalId(userId)
    const discountRules = await DiscountRulesRepository.findAll()

    const discount = await DiscountRulesService.calculateDiscount(discountRules, { user })

    return ({ 
        discount,
        amount: 3000
    })
}

module.exports = {
    getDiscount
}