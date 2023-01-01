<template>
  <div>
    <svg-icon icon-class="doc" style="height: 2.5em;font-size: 18px;cursor: pointer" @click.native="goto"/>
  </div>
</template>

<script>
export default {
  name: 'mosbrhDoc',
  data() {
    return {
      url: 'http://inkfoxer159753.gitee.io/mosbrh_blog_doc/#/'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
