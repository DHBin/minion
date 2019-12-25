module.exports = {
  lang: 'zh-CN',
  title: 'Minion',
  description: 'Minion 快速开发手脚架',
  base: '/minion/',
  plugins: ['vuepress-plugin-smooth-scroll', '@vuepress/active-header-links'],
  themeConfig: {
    nav: require('./nav/zh')
  },
  head: [
    ['link', { rel: 'icon', href: `/logo.png` }]
  ]
}
