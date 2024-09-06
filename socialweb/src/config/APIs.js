import axios from "axios"
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/WebForAlumni/api/'

export const endpoints = {
    'topic':'/Topic',
    'post': '/Post',
    'major':'/Major',
    'addPost':'/AddPost',
    'login': '/login',
    'current-user': '/current-user',
    'account': (userId) => `/Account/${userId}/`,
    'Post': (postId) => `/Post/${postId}/`,
    'notification':'/Notification',
    'register':'/Users',
    'comment':(postId) =>`/Comment/${postId}/`,
    'addCMT':(postId) => `/AddComment/${postId}`,
    'like':(postId)=> `/LikeHaha/${postId}`,
    'likeAll':(postId)=> `/Like/${postId}`,
    'user':'/Users'

   
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