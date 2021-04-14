// Add a response interceptor 每次请求完成都会先走这个方法
axios.interceptors.response.use(function (response) {

    let {status, data} = response.data;
    if (status == 2000) {
        return data;
    }
    if (status == 4002 || status == 4003 || status == 4004) {
        location.href = '/login.html'
    }

    //阻止代码继续往下执行
    return Promise.reject(false);

}, function (error) {

    return Promise.reject(error);
});