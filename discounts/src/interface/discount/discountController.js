const discountFacade = require('../../interface/facade/discountFacade')

module.exports = {
    getDiscount: async (call) => {
        return ({
            products: await discountFacade.getDiscount(call.request.userId, call.request.products)
        })
    }
}