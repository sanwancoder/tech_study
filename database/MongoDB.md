# MongoDB

- 官网文档
   - [https://docs.mongodb.com/](https://docs.mongodb.com/)
- GitHub源码
   - [https://github.com/mongodb/mongo](https://github.com/mongodb/mongo)



# 学习资料
## 学习教程
- [MongoDB 教程](http://www.runoob.com/mongodb/mongodb-tutorial.html)


## 客户端推荐
- [Robo 3T 免费](https://robomongo.org/)    **良心推荐**
- [MongoDB上有哪些比较好的GUI工具？ - 何健的回答 - 知乎](https://www.zhihu.com/question/31903748/answer/54321387)


# 基础理论知识
1. MongoDB允许ad hoc查询,但是不支持join连接查询
2. 在MongoDB里，数据的基本单位是BSON文件。
3. MongoDB不支持事务
4. MongoDB集合有**盖子集合**、**TTL(time-to-live)集合**;还有两个特殊的集合system.namespace和system.indexes

## 参考文章

# MongoDB高级聚合查询

| SQL 操作/函数 | mongodb聚合操作 |
| --------- | --------- |
|where	|$match |
|group by	|$group |
|having|	$match |
|select|	$project |
|order by	|$sort |
|limit　	|$limit |
|sum()|	$sum |
|count()|	$sum |
|join|$lookup(v3.2 新增) |


## 参考文章
- [mongodb高级聚合查询](https://www.cnblogs.com/zhoujie/p/mongo1.html)
- [https://docs.mongodb.com/manual/](https://docs.mongodb.com/manual/)

# 部署
## Docker环境下MongoDB部署


# 好文必读
- [12 Best Free and Open Source NoSQL Databases](http://theprofessionalspoint.blogspot.com/2014/01/12-best-free-and-open-source-nosql.html)
- [Types and Examples of NoSQL Databases](http://theprofessionalspoint.blogspot.com/2014/01/types-and-examples-of-nosql-databases.html)
- [BSON的介绍及BSON与JSON的区别](<https://blog.csdn.net/m0_38110132/article/details/77716792>)
- [What does being schema-less mean for a NoSQL Database?](<https://stackoverflow.com/questions/15589184/what-does-being-schema-less-mean-for-a-nosql-database>)
- [why-schemaless](<https://www.mongodb.com/blog/post/why-schemaless>)







# 关注

- <https://ravendb.net/>  **A NoSQL Database that's fully transactional - *RavenDB* NoSQL Document Database allows 1 million reads and 150000 writes per second.**

