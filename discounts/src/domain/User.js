const camelCase = require('camelcase-keys');

class User {
    constructor(params) {
        this.id = params.id
        this.externalId = params.externalId
        this.firstName = params.firstName
        this.lastName = params.lastName
        this.dateOfBirth = new Date(params.dateOfBirth)
    }

    static fromDB(dbObject) {
        return new User(camelCase(dbObject))
    }
}

module.exports = User