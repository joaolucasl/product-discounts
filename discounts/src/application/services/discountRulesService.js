const vm = require('vm')

const calculateDiscount = async (discountRules, { user, product }) => {

    const discounts = discountRules.map(rule => getDiscountParamsFromRule(rule, { user, product }))

    const finalDiscount = calculateFinalDiscount(discounts)

    
    return finalDiscount
}

const calculateFinalDiscount = (discountParameters) => {
    // If we have more than one MAX_DISCOUNT, we assume the greatest percentage as the right one
    const maxDiscount = discountParameters
        .filter(params => params.type == 'MAX_DISCOUNT')
        .reduce((currentMax, params) => Math.min(currentMax, params.percentage), 100)

    const discount = discountParameters
        .filter(params => params.type == 'DISCOUNT')
        .reduce((totalDiscount, param) => totalDiscount += param.percentage, 0.0)

    const finalDiscount = (discount < maxDiscount) ? discount : maxDiscount

    return finalDiscount
}

const getDiscountParamsFromRule = (rule, { user, product }) => {
    const context = {
        percentage: 0.0,
        user: user,
        product: product,
        now: new Date()
    }

    try {
        vm.runInNewContext(rule.rule, context)
    } catch (ex) {
        console.error(ex)
    }

    const params = { percentage: context.percentage, type: rule.type };

    return params;
}

module.exports = {
    calculateDiscount
}