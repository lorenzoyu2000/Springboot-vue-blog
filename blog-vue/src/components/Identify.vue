<template>
  <div class="code" @click="refreshCode()">
    <s-identify :identifyCode="identifyCode"></s-identify>
  </div>
</template>

<script>
import SIdentify from "@/components/SIdentify.vue";
export default {
  name: "Identify",
  components: {SIdentify},
  data() {
    return {
      identifyCode: "",
      identifyCodes: "0123456789abcdwerwshdjeJKDHRJHKOOPLMKQ",//绘制的随机数
    }
  },
  created() {
    this.refreshCode()
  },
  methods: {
    refreshCode() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
    },
    randomNum(min, max) {
      max = max + 1
      return Math.floor(Math.random() * (max - min) + min)
    },
    // 随机生成验证码字符串
    makeCode(data, len) {
      for (let i = 0; i < len; i++) {
        this.identifyCode += data[this.randomNum(0, data.length - 1)]
      }
    }
  }
}
</script>

<style scoped>

</style>
