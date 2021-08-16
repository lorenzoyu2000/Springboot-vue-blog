<template>
  <div class="conTop">
    <Header></Header>
    <div class="m-blog">
      <h2>{{ blog.title }}</h2>
      <el-link icon="el-icon-edit" v-if="ownBlog">
        <router-link :to="{name:'BlogEdit',params:{blogId:blog.id}}">
          编辑
        </router-link>
      </el-link>
      <el-link type="warning" v-if="ownBlog" @click="deleteBlogById(blog.id)">
          <i class="el-icon-view el-icon--right"></i>
          删除
      </el-link>
      <el-divider></el-divider>
      <div class="markdown-body" v-html="blog.content">
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
import '_github-markdown-css@4.0.0@github-markdown-css'


export default {
  name: "BlogDetail",
  components: {Header},
  data() {
    return {
      blog: {
        id: '',
        title: "",
        content: "",
      },
      ownBlog: false
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    console.log(blogId)
    const _this = this
    if (blogId) {
      this.$axios.get('/blog/' + blogId).then(res => {
        const blog = res.data.data
        _this.blog.id = blog.id
        _this.blog.title = blog.title
        var MarkdownIt = require("markdown-it")
        var md = new MarkdownIt()
        var result = md.render(blog.content)
        _this.blog.content = result
        _this.ownBlog = (blog.userId === _this.$store.getters.getUser.id)
      })
    }
  },
  methods: {
    deleteBlogById(blogId) {
      const _this = this
      this.$axios.get('/blogDelete/' + blogId, {
        headers: {
          "Authorization": localStorage.getItem("token")
        }
      }).then((res) => {
        _this.$alert('操作成功', '提示', {
          confirmButtonText: '确定',
          callback: action => {
            _this.$router.push("/blogs")
          }
        })
      })
    }

  }
}
</script>

<style scoped>
.m-blog {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  max-width: 960px;
  min-height: 550px;
  padding: 0px 15px;
  margin: 0 auto;
}

.conTop {
  background: url("../assets/3.jpg");
  width: 100%;
  height: 100%;
  margin: -20px -20px 0 0;
  background-size: 100% 100%;
}
</style>
