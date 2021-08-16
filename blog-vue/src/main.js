import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import axios from "axios";
import "./permission"
import "./axios"

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

Vue.config.productionTip = false

Vue.use(Element)

//给Vue函数添加一个原型属性$axios,直接用this.$axios就能执行axios 方法
Vue.prototype.$axios = axios
//引入markdown-ui
Vue.use(mavonEditor)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
