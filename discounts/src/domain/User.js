class User {
    constructor(params) {
        this.id = params.id
        this.externalId = params.externalId
        this.firstName = params.firstName
        this.lastName = params.lastName
        this.dateOfBirth = new Date(params.dateOfBirth)
    }
}

module.exports = User