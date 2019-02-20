const User = require('../../src/domain/User')

const normalUser = new User({
    id: 1,
    externalId: "USR-AAAAAAAAAAAA",
    firstName: "John",
    lastName: "Cena",
    dateOfBirth: new Date()
})

module.exports = {
    normalUser,
}