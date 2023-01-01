'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  VUE_mosbrh_WEB: '"http://localhost:9527"',
  PICTURE_API: '"http://localhost:8607/mosbrh-picture"',
	WEB_API: '"http://localhost:8607/mosbrh-web"',
  SEARCH_API: '"http://localhost:8607/mosbrh-search"',

})
