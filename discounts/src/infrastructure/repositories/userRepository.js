const { db } = require('../database')
const UserModel = require('../../domain/User')

const findByExternalId = async (id) => {
    const user = await db.select().from('users').where({ external_id: id }).first()

    return UserModel.fromDB(user)
}

module.exports = {
  findByExternalId
}