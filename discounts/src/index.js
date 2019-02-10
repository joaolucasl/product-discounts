const env = require('yenv')()
const path = require('path')
const grpc = require('grpc-kit')
const server = grpc.createServer();
const discountService = require('./application/services/discountService')

server.use({
  protoPath: path.resolve(__dirname, "interface/discount/DiscountService.proto"),
  packageName: "discount",
  serviceName: "DiscountService",
  routes: discountService
})

module.exports = server