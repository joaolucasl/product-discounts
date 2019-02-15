const discountFacade = require('../../interface/facade/discountFacade')

module.exports = {
    getDiscount: async (call) => {
        return await discountFacade.getDiscount(call.request.userId, call.request.productId)
    }
}