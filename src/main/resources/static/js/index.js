let vue = new Vue({
    el: '#app',
    created() {
        this.findAll();

    },
    data: {
        tableData: [],
        formData: {},
        imgUrl: './images/user2-160x160.jpg'

    },
    methods: {
        findAll() {
            axios.get(`employee`).then(response => {
                console.log(response);
                this.tableData = response;
            })
        },
        //根据Id查找
        findById(id) {
            axios.get(`employee/${id}`).then(response => {
                this.formData = response;
                this.imgUrl = response.employeeImg;
            })

        },
        editOrAdd() {
            if (this.formData && this.formData.employeeId) {
                //修改
                this.updateEntity();

            } else {
                //新增
                this.addEntity();
            }

        },
        updateEntity() {
            axios.put(`employee`,this.formData).then(response => {
                this.findAll();
            })
        },
        addEntity() {
            axios.post(`employee`,this.formData).then(response=>{
                this.findAll();
            })

        },
        //文件上传
        chooseImage(e){
            console.log(e);
            let file = e.target.files[0];
            let fileReader = new FileReader();
            fileReader.readAsDataURL(file);
            fileReader.onloadend = function (e) {
                this.imgUrl = e.target.result;
                let result = e.target.result;

                let obj = {
                    base64: result,
                    suffix: file.name.substr(file.name.lastIndexOf('.') + 1)
                };
                axios.post(`common/upload`, obj).then(response => {
                    console.log(response);
                    this.imgUrl = response;
                    this.formData.employeeImg = response;
                })
            }.bind(this)


        },
        //根据id删除
        deleteById(){
            axios.delete(`employee/${this.formData.employeeId}`).then(response=>{
                this.findAll();
            })

        },

    }

});