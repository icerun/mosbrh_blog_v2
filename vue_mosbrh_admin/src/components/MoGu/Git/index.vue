<template>
  <div>
    <svg-icon class="giteeSvg" icon-class="gitee" @click.native="goto" style="height: 2.5em;font-size: 18px;cursor: pointer" />
  </div>
</template>

<script>
export default {
  name: 'mosbrhGit',
  data() {
    return {
      url: 'https://gitee.com/inkfoxer159753/mosbrh_blog_v2'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
<style scoped>

</style>
