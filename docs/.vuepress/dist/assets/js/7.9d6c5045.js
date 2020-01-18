(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{209:function(t,s,a){"use strict";a.r(s);var n=a(0),e=Object(n.a)({},(function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[a("h1",{attrs:{id:"配置"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#配置"}},[t._v("#")]),t._v(" 配置")]),t._v(" "),a("h2",{attrs:{id:"环境配置"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#环境配置"}},[t._v("#")]),t._v(" 环境配置")]),t._v(" "),a("p",[t._v("host添加对应组件IP")]),t._v(" "),a("div",{staticClass:"language- extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v("127.0.0.1   minion-register\n127.0.0.1   minion-mysql\n127.0.0.1   minion-redis\n")])])]),a("h2",{attrs:{id:"服务配置"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#服务配置"}},[t._v("#")]),t._v(" 服务配置")]),t._v(" "),a("p",[t._v("运行nacos，新增下面配置信息")]),t._v(" "),a("blockquote",[a("p",[t._v("minion-dev.yml")])]),t._v(" "),a("div",{staticClass:"language-yaml extra-class"},[a("pre",{pre:!0,attrs:{class:"language-yaml"}},[a("code",[a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("management")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("endpoints")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("web")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("exposure")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n        "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("include")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"*"')]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("endpoint")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("health")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("show-details")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" ALWAYS\n"),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("spring")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("redis")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("host")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("redis\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("password")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" redis密码\n")])])]),a("blockquote",[a("p",[t._v("minion-auth-dev.yml")])]),t._v(" "),a("div",{staticClass:"language-yaml extra-class"},[a("pre",{pre:!0,attrs:{class:"language-yaml"}},[a("code",[a("span",{pre:!0,attrs:{class:"token comment"}},[t._v("# 数据源")]),t._v("\n"),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("spring")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("datasource")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("type")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" com.zaxxer.hikari.HikariDataSource\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("driver-class-name")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" com.mysql.cj.jdbc.Driver\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("username")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" dhb\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("password")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" 数据库密码\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("url")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" jdbc"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("mysql"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("mysql"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("3306/minion_auth"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("?")]),t._v("characterEncoding=utf8"),a("span",{pre:!0,attrs:{class:"token important"}},[t._v("&zeroDateTimeBehavior")]),t._v("=convertToNull"),a("span",{pre:!0,attrs:{class:"token important"}},[t._v("&useSSL")]),t._v("=false"),a("span",{pre:!0,attrs:{class:"token important"}},[t._v("&useJDBCCompliantTimezoneShift")]),t._v("=true"),a("span",{pre:!0,attrs:{class:"token important"}},[t._v("&useLegacyDatetimeCode")]),t._v("=false"),a("span",{pre:!0,attrs:{class:"token important"}},[t._v("&serverTimezone")]),t._v("=Asia/Shanghai\n"),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("dubbo")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("registry")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("address")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" nacos"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("register"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("8848")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("cloud")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("subscribed-services")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("umps\n")])])]),a("blockquote",[a("p",[t._v("minion-gateway-dev.yml")])]),t._v(" "),a("div",{staticClass:"language-yaml extra-class"},[a("pre",{pre:!0,attrs:{class:"language-yaml"}},[a("code",[a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("spring")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("cloud")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("gateway")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("routes")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n        "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("id")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("auth\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("uri")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" lb"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("auth\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("predicates")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" Path=/auth/**\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("filters")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" StripPrefix=1\n        "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("id")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("upms"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("biz\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("uri")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" lb"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("upms"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("biz\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("predicates")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" Path=/upms/**\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("filters")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v(" StripPrefix=1\n          "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("metadata")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("swagger")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"true"')]),t._v("\n            "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("swagger_title")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token string"}},[t._v('"后台管理系统"')]),t._v("\n")])])]),a("blockquote",[a("p",[t._v("minion-upms-biz-dev.yml")])]),t._v(" "),a("div",{staticClass:"language-yaml extra-class"},[a("pre",{pre:!0,attrs:{class:"language-yaml"}},[a("code",[a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("swagger")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("enabled")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token boolean important"}},[t._v("true")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("title")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" upms\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("description")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token string"}},[t._v("'后台管理系统'")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("base-package")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" cn.dhbin.minion.upms\n"),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("security")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("oauth2")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("client")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("client-id")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" upms\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("client-secret")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" upms\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("resource")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n      "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("token-info-uri")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" http"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("auth/oauth/check_token\n"),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("dubbo")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("scan")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("base-packages")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" cn.dhbin.minion.upms.service.impl\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("protocol")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("name")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" dubbo\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("port")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" "),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("-1")]),t._v("\n  "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("registry")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("\n    "),a("span",{pre:!0,attrs:{class:"token key atrule"}},[t._v("address")]),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v(" nacos"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),t._v("//minion"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("-")]),t._v("register"),a("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(":")]),a("span",{pre:!0,attrs:{class:"token number"}},[t._v("8848")]),t._v("\n")])])])])}),[],!1,null,null,null);s.default=e.exports}}]);