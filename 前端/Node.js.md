# Node.js
## 介绍

# NPM
## 介绍
NPM（node package manager),通常称为node包管理器，主要功能就是管理node包，包括：安装、卸载、更新、查看、搜索、发布等。NPM是基于couchdb一个数据库，详细记录了每个包的信息（作者、版本、依赖、授权信息等）

npm（全称 Node Package Manager，即“node包管理器”）是Node.js默认的、以JavaScript编写的软件包管理系统。

npm可以管理本地项目的所需模块并自动维护依赖情况，也可以管理全局安装的JavaScript工具。如果一个项目中存在package.json文件，那么用户可以直接使用npm install命令自动安装和维护当前项目所需的所有模块。在package.json文件中，开发者可以指定每个依赖项的版本范围，这样既可以保证模块自动更新，又不会因为所需模块功能大幅变化导致项目出现问题。开发者也可以选择将模块固定在某个版本之上

## 网站
- [官网](https://www.npmjs.com/)

## 安装
### windows
- [https://nodejs.org/en/](https://nodejs.org/en/)

![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/npmversion.PNG?raw=true)

### macOS下安装

## npm相关配置
### 换源
```
一、使用淘宝镜像
1.临时使用
npm --registry https://registry.npm.taobao.org install express
2.持久使用
npm config set registry https://registry.npm.taobao.org
3.通过cnpm
npm install -g cnpm --registry=https://registry.npm.taobao.org
二、使用官方镜像
npm config set registry https://registry.npmjs.org/
三、查看npm源地址
npm config get registry

作者：nickfox
链接：https://www.jianshu.com/p/f311a3a155ff
来源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
```
