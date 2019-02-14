const knex = require("knex")
const knexConfig = require('../config/knexfile')

module.exports =  {
    db: knex({ ...knexConfig })
}