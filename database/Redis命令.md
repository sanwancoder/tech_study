# Redis常用命令

## 网址
- [https://redis.io/commands](https://redis.io/commands)
- [http://doc.redisfans.com/](http://doc.redisfans.com/)

## 连接
```
//  在远程服务上执行命令进行连接
redis-cli -h 127.0.0.1 -p 6379 -a "mypass"
// 输入密码 
auth 'mypassword'
// 选择redis数据库
select 10
```


## keys