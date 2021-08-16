import axios from 'axios'
import Element from 'element-ui'
import store from './store'
import router from './router'
//前端拦截

//设置拦截地址
axios.defaults.baseURL = "http://localhost:9000"

//前置拦截
axios.interceptors.request.use(config => {
    console.log("前置拦截成功！")
    return config
})
//后置拦截
axios.interceptors.response.use(response => {
        console.log("后置置拦截成功！")
        let res = response.data;
        if (res.code === 200) {
            return response
        } else {
            Element.Message.error('发生错误', {duration: 2 * 1000});
            return Promise.reject(response.data.msg)
        }

    },
    error => {
        console.log("错误拦截")
        console.log(error)
        if(error.response.data){
            error.message = error.response.data.msg
        }

        if (error.response.status === 401) {
            store.commit("REMOVE_INFO")
            router.push("/login")
        }

        Element.Message.error(error.message, {duration: 2 * 1000});
        return Promise.reject(error)
    })