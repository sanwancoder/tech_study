# ssh安装

## 安装方法
```
1. get --no-check-certificate -O shadowsocks-all.sh https://raw.githubusercontent.com/teddysun/shadowsocks_install/master/2. shadowsocks-all.sh
2. chmod +x shadowsocks-all.sh
3. ./shadowsocks-all.sh 2>&1 | tee shadowsocks-all.log
```

## 卸载方法
```
./shadowsocks-all.sh uninstall
```
## 启动脚本
```
Shadowsocks-Python 版：
/etc/init.d/shadowsocks-python start | stop | restart | status

ShadowsocksR 版：
/etc/init.d/shadowsocks-r start | stop | restart | status

Shadowsocks-Go 版：
/etc/init.d/shadowsocks-go start | stop | restart | status

Shadowsocks-libev 版：
/etc/init.d/shadowsocks-libev start | stop | restart | status
```
