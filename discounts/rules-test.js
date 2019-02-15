const vm = require('vm')

const rules = [{
    id: 1,
    external_id: 'RUL-AAAAAAAAAAAA',
    name: '5% discount on User birthday',
    rule: 'const sameDay = user.dateOfBirth.getDate() == now.getDate(); const sameMonth = user.dateOfBirth.getMonth() == now.getMonth(); if (sameDay && sameMonth) { discount = 0.05; }',
    type: 'DISCOUNT'
},
{
    id: 2,
    external_id: 'RUL-BBBBBBBBBBBB',
    name: '10% discount on 2019 Black Friday',
    rule: 'if (now.getTime() == new Date(2019, 11, 25).getTime() ) { discount = 0.1; }',
    type: 'DISCOUNT'
},
{
    id: 3,
    external_id: 'RUL-CCCCCCCCCCCC',
    name: 'Max Discount of 10%',
    rule: 'discount = 0.1',
    type: 'MAX_DISCOUNT'
}]

const user = {
    id: 1,
    externalId: 'USR-AAAAAAAAAAAA',
    firstName: 'John',
    lastName: 'Doe',
    dateOfBirth: new Date('2010-02-15T00:00:00.000Z')
}

const product = {}

const applyRule = (rule, user, product) => {
    const context = {
        discount: 0.0,
        user: user,
        product: product,
        now: new Date()
    }

    vm.runInNewContext(rule, context)

    console.log(context.dob, context.n)
    return context.discount;
}


const discount = rules.reduce((acc, rule) => acc += applyRule(rule.rule, user, product), 0.0)

console.log(discount)