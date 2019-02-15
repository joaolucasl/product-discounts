const path = require('path')
const grpc = require('grpc-kit')
const server = grpc.createServer()
const discountController = require('./interface/discount/discountController')

server.use({
  protoPath: path.resolve(__dirname, "interface/discount/DiscountService.proto"),
  packageName: "discount",
  serviceName: "DiscountService",
  routes: discountController
})

module.exports = server