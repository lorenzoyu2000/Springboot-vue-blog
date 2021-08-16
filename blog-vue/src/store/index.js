import Vue from 'vue'
import Vuex from 'vuex'

// 使用localStorage存储token，sessionStorage存储用户信息(用户信息不需要长久保存)
Vue.use(Vuex)
export default new Vuex.Store({
    state: {
        token: '',
        //对象转字符串
        userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
    },
    mutations: {
        //set
        SET_TOKEN: (state, token) => {
            state.token = token
            localStorage.setItem("token", token)
        },
        SET_USERINFO: (state, userInfo) => {
            state.token = userInfo
            sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
        },
        REMOVE_INFO: (state) => {
            state.token = ''
            state.userInfo = {}
            localStorage.setItem("token", '')
            sessionStorage.setItem("userInfo",JSON.stringify(''))
        },
    },
    getters: {
        //get
        getUser:state => {
            return state.userInfo
        }
    },
    actions: {},
    modules: {}
})
