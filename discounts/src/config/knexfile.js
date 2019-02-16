require('dotenv').load()

module.exports = {
    client: 'mysql',
    connection: {
      host: process.env.MYSQL_HOST,
      database: process.env.MYSQL_DATABASE,
      user: process.env.MYSQL_USER,
      password: process.env.MYSQL_PASSWORD,
      dateStrings: true
    }
}