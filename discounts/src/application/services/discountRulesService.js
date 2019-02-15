const vm = require('vm')
const UserRepository = require('../../infrastructure/repositories/userRepository')

const calculateDiscount = async (discountRules, { user, product }) => {
    const discount = discountRules.reduce((totalDiscount, rule) => totalDiscount += applyRule(rule.rule, { user, product }), 0.0)

    return discount
}

const applyRule = (rule, { user, product }) => {
    const context = {
        discount: 0.0,
        user: user,
        product: product,
        now: new Date()
    }

    vm.runInNewContext(rule, context)

    return context.discount;
}

module.exports = {
    calculateDiscount
}