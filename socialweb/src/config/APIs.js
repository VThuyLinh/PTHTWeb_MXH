import axios from "axios"
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/WebForAlumni/api/'

export const endpoints = {
    'topic':'/Topic',
    'post': '/Post',
    'login': '/login',
    'current-user': '/current-user',
    'account': '/Account',
    'notification':'/Notification',
   
}

export const authAPIs = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': cookie.load("access-token")
        }
    })
}

export default axios.create({
    baseURL: BASE_URL
});