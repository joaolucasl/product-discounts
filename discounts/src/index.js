const env = require('yenv')()
const Hapi = require('hapi')
const mongoose = require('mongoose')

const server = Hapi.server({
  port: env.PORT,
  host: env.HOST
})

server.route({
  method: 'GET',
  path: '/',
  handler: (request, h) => {
    return 'This is the response from the root path';
  }
})

server.route({
  method:'GET',
  path:'/{name}',
  handler: (request, h) => {
    return 'This is the response from the /{name} path and the value is ' +
      encodeURIComponent(request.params.name) + '!'
  }
})

module.exports = server