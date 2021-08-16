<template>
  <div class="conTop">
    <div  class="login_box">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="auto" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
</template>
<script>
import Identify from "@/components/Identify.vue";

export default {
  name: "Login",
  components: {Identify},
  data() {
    return {
      ruleForm: {
        username: 'yulikai',
        password: '111111',
      },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'}
        ],
        code: [
          {required: true, message: '请输入验证码', trigger: 'blur  '}
        ],
      },
    };
  },
  methods: {
    //表单验证
    submitForm(formName) {
      //valid是validate方法的回调参数,代表是否通过验证,如果为true就是通过
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('/login', this.ruleForm).then(res => {
            const jwt = res.headers['authorization']
            const userInfo = res.data.data
            // 把获取的数据存储到store中，共享数据到全局
            _this.$store.commit("SET_TOKEN", jwt)
            _this.$store.commit("SET_USERINFO", userInfo)

            _this.$router.push("/blogs")
          })
              .catch(() => {
                this.$message({
                  type: 'error',
                  message: '账户名或密码错误！'
                });
              })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
<!--scoped表示css样式只在该页面起作用-->
<style scoped>
.demo-ruleForm {
  max-width: 500px;
  max-height: 250px;
  margin: 30px auto;

}

.conTop {
  background: url("../assets/2.jpg");
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
}

.login_box{
  width: 600px;
  height: 250px;
  position: absolute;
  left: 50%;
  top: 50%;
  border-radius: 3px;
  transform: translate(-50%,-50%);
}

</style>