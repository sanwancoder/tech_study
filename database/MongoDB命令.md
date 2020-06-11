
##  基本操作
```
// 显示当前数据库服务器上的数据库
show dbs
// 显示数据库中所有的集合
show collections
// 查看数据库服务器的状态
db.serverStatus()
// 切换数据库 
use search_log
// 查询指定数据库统计信息(先切换数据库)
db.stats()
// 查询指定数据库包含的集合名称列表
db.getCollectionNames()
```

## MongoDB命令帮助系统
```
// 数据库操作更详细的帮助命令: 
db.help()
// 集合类帮助  (其中没有search_log是集合名称)
use archives
db.search_log.help()  
```
![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/use_database.PNG?raw=true)

## 数据库操作
```
//创建数据库(myTestDB不存在 在向myTestDB插入数据时候 自动回创建改数据库)
use myTestDB
//展示全部的数据库
show dbs
//删除数据库
myTestDB.dropDatabase()
```

## 集合Collection的操作 
```
// 集合插入数据(创建storeCollection)
db.storeCollection.save({'version':'3.5', 'segment':'e3ol6'})
// 查看集合条数
db.storeCollection.count()
// 删除集合
db.storeCollection.drop()
// 展示全部的集合
show collections
// 删除操作
db.getCollection('storeCollection').remove({'version':'3.5'});
db.storeCollection.remove({'version':'3.5'});
// 展示指定的列
db.getCollection('storeCollection').find({},{"version":1})
db.storeCollection.find({},{"version":1})
// in语法
db.getCollection('fc_album').find({"core_id":{$in:
["7fca9c25-2104-b28b-44fa-9eaa6fb6e7ab",
"ad2e0309-8ea1-cd98-6d69-a10ddd7ec6e5",
"139da06f-c6ce-7abb-f85a-4d8f3c8c1fb2"]}});
// nin语法(not in)
db.getCollection('fc_album').find({"core_id":{$nin:
["7fca9c25-2104-b28b-44fa-9eaa6fb6e7ab",
"ad2e0309-8ea1-cd98-6d69-a10ddd7ec6e5",
"139da06f-c6ce-7abb-f85a-4d8f3c8c1fb2"]}}).count();
// 时间相关
db.getCollection('hellohahaha').find({"update_time" : {$lte:ISODate("2019-06-15T00:00:00.652Z")}}).count();
db.getCollection('hellohahaha').find({"update_time" : {$gte:ISODate("2019-06-15T00:00:00.652Z")}}).count();
db.getCollection('hellohahaha').remove({"update_time" : {$lte:ISODate("2019-06-15T00:00:00.652Z")}})
```
## 集合Collection 查询操作
//findAll简单粗暴
db.getCollection('hellohahaha').find();

//条件查询  lte
db.getCollection('hellohahaha').find({"similarity" : {$lte:90}}).count();

//聚合操作
db.getCollection('photo_bfa419a6-5ae7-4f03-9f66-3f6a19ed4a3d').aggregate([
  {
    "$group": {_id: "$url", count: {"$sum": 1}}
  },{"$match": {"_id" :{ "$ne" : null } , "count" : {"$gt": 1} } }
], { allowDiskUse: true } );

## | SQL 操作/函数 | mongodb聚合操作 |
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

## 启动与终止

## 安全管理

## 数据备份、恢复与迁移管理

## 远程连接管理

## 杂项

## 参考文章&好文必读
- [https://blog.csdn.net/shirdrn/article/details/7105539](https://blog.csdn.net/shirdrn/article/details/7105539)


