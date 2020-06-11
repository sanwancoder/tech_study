## 简介
Redis 是一款开源的,基于BSD许可的,**单线程模式**,高级键值(key-value)缓存(cache)和存储(store)系统
## 官网
[https://redis.io/](https://redis.io/)
## GitHub源码
[https://github.com/antirez/redis](https://github.com/antirez/redis)
## 客户端推荐
- [Redis Desktop Manager](https://redisdesktop.com/) *强烈推荐*
- [FastoRedis ](<https://fastoredis.com/>)  ***分收费与付费两种***



##  学习
1. 数据结构
2. 部署方式
3. 持久化方式 
   - ***RDB:***在指定的时间间隔内生成数据集的时间点快照(point-in-time snapshot).安全性较差、尺寸小、速度快;适用于备份和灾难恢复。
   - ***AOF***持久化记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集。<br/>
  - [Redis持久化](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/Redis/Redis%E6%8C%81%E4%B9%85%E5%8C%96.md)



## 缓存那些事儿
### 缓存穿透
简介:  正常情况下，我们去查询数据都是存在。那么请求去查询一条压根儿数据库中根本就不存在的数据，也就是缓存和数据库都查询不到这条数据，但是请求每次都会打到数据库上面去。这种查询不存在数据的现象我们称为缓存穿透。<br/><br/>
解决办法:
- 使用Bloom filter
- 缓存空值（记得使用设置过期时间） 

### 缓存击穿
简介: 在平常高并发的系统中，大量的请求同时查询一个 key 时，此时这个key正好失效了，就会导致大量的请求都打到数据库上面去。这种现象我们称为缓存击穿。<br/><br/>
解决办法：
1. 互斥锁


### 缓存雪崩
简介: 缓存雪崩的情况是说，当某一时刻发生大规模的缓存失效的情况，比如你的缓存服务宕机了，会有大量的请求进来直接打到DB上面。结果就是DB 称不住，挂掉。<br/><br/>
解决办法：
1. 事前: 使用集群缓存，保证缓存服务的高可用  <br/> 事中: ehcache本地缓存 + Hystrix限流&降级,避免MySQL被打死 <br/> 事后: 开启Redis持久化机制，尽快恢复缓存集群

### 热点数据失效
简介: 我们在设置缓存的时候，一般会给缓存设置一个失效时间，过了这个时间，缓存就失效了。对于一些热点的数据来说，当缓存失效以后会存在大量的请求过来，然后打到数据库去，从而可能导致数据库崩溃的情况。<br/><br/>
解决办法:
1. 设置不同的失效时间
2. 互斥锁

## 使用docker部署redis 


## 好文必读
- [12 Best Free and Open Source NoSQL Databases](http://theprofessionalspoint.blogspot.com/2014/01/12-best-free-and-open-source-nosql.html)
- [Types and Examples of NoSQL Databases](http://theprofessionalspoint.blogspot.com/2014/01/types-and-examples-of-nosql-databases.html)


## 问题解决

- [redis启动出错Creating Server TCP listening socket 127.0.0.1:6379: bind: No error](<https://www.cnblogs.com/shaosks/p/7089786.html>)

