module.exports = {
  lang: 'zh-CN',
  title: 'Minion',
  description: 'Minion 快速开发脚手架',
  base: '/minion/',
  plugins: ['vuepress-plugin-smooth-scroll', '@vuepress/active-header-links'],
  themeConfig: {
    sidebarDepth: 4,
    nav: require('./nav/zh'),
    sidebar: {
      '/guide/': getGuideSidebar()
    }
  },
  head: [
    ['link', { rel: 'icon', href: `/logo.png` }]
  ]
}

function getGuideSidebar() {
  return [
    {
      title: '开始',
      collapsable: false,
      children: ["", "dependencies", "structure", "config", "minion-core-restful"]
    }
  ]
}
