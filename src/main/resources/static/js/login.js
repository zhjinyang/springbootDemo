let vue = new Vue({
    el: '.login',
    data: {
        email: '1668762316@qq.com',
        code: '',
        status: ''
    },
    methods: {
        //获取邮箱验证码
        getEmailCode() {
            axios.get(`login/getEmailCode?email=${this.email}`).then(response => {
                console.log(response);

            })

        },

        //登录
        doLogin() {
            axios.post(`login/doLogin?email=${this.email}&code=${this.code}`).then(response => {

                location.href = 'index.html'
            })
        },

    }
});