const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanbaoxiuguanli/",
            name: "xiaoyuanbaoxiuguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanbaoxiuguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园报修管理系统"
        } 
    }
}
export default base
