# Quick Start
## 简介
- [https://github.com/ctripcorp/apollo/wiki/Quick-Start](https://github.com/ctripcorp/apollo/wiki/Quick-Start)
- 依赖: Mysql、注册中心、jdk1.8+

## demo.sh代码修改如下
```
# apollo config db info
apollo_config_db_url=jdbc:mysql://localhost:3306/ApolloConfigDB?characterEncoding=utf8
apollo_config_db_username=root
apollo_config_db_password=123456

# apollo portal db info
apollo_portal_db_url=jdbc:mysql://localhost:3306/ApolloPortalDB?characterEncoding=utf8
apollo_portal_db_username=root

# meta server url
config_server_url=http://localhost:8761
admin_server_url=http://localhost:8090
eureka_service_url=$config_server_url/eureka/
portal_url=http://localhost:8070
```

在Git bash下执行 **./demo.sh start**

## 效果图
![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/apollo_demo_sh.png?raw=true)

# 原理学习
- [https://github.com/ctripcorp/apollo](https://github.com/ctripcorp/apollo)
# 源码学习

- [Apollo配置中心-配置热发布原理](https://zhuanlan.zhihu.com/p/40706513)