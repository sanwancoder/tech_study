## Linux目录结构

## 各个目录简述

### 分区1：启动分区

/boot  Boot 存放开机文件，一般为100M左右（50M~200M）。



### 分区2：根分区

/ 根目录（必须与/bin, /sbin, /lib, /dev, /etc这5个目录在同一分区，不可挂载在不同分区，否则系统无法正常启动）

 - /bin  Binaries 普通命令，如文件操作。

 - /sbin  System-only binaries 系统命令，如分区、格式化操作。

 - /lib  Libraries 开机时会用到的函式库，以及/bin或/sbin下的指令会用到的函式库。

 - /dev  Devices 在linux中任何装置与周边设备都是以档案的型态存在于这个目录当中，如/dev/tty, /dev/hd*, /dev/sd*等。

 - /etc  Etcetera 系统的所有配置文件，包括通过系统自动安装的程序的配置文件，如nginx，mysql等配置文件。

 - /media  Media 一般是系统自动挂载可移除的装置，挂载后装置图标会出现在桌面窗口的左边栏。如软碟、光碟、DVD、U盘、移动硬盘（/media/floppy, /media/cdrom）。

 - /mnt  Mount 一般是用于让用户自己挂载其他文件系统，挂载后装置图标不会出现在桌面窗口的左边栏。

 - /tmp  Temporary files 临时目录，系统会定期或目录大小到达一定上线后自动清理。（因为读写比较频繁，容易损坏磁盘，可单独分区）


 - /usr  Unix Software Resource 通过系统自动安装的软件目录。（如果内容较多，可单独分区）

 - /var  Variable files 软件运行所产生的数据存放目录，如日志、数据库文件、缓存文件。（如果内容较多，可单独分区，或与/usr放在同一分区）

 - /opt  Optionally 安装第三方软件，通常是用户自己编译的软件；把软件安装一个文件夹内，包括它的运行文件，所需要的库文件、生成临时文件、产生的内容等所有和该软件相关的都放在该文件夹内，不用时方便删除。

 - /srv  Service 存放一些对外的服务数据（不是软件，而是数据），如web、ftp、流媒体等。（如果内容较多，可单独分区）（关于Web服务器存放html目录的纠正，/srv/www，而不是/var/www，另见《关于linux下/srv、/var和/tmp的职责区分》）

 - /root  Root 管理员的home目录。

 - /lost+found  Lost+Found 这个目录在大多数情况下都是空的。但是如果你正在工作突然停电，或是没有用正常方式关机，在你重新启动机器的时候，有些文件就会找不到应该存放的地方，对于这些文件，系统将他们放在这个目录下。

 - /sys  System 正在运行的硬件设备的驱动程序信息。（虚拟文件系统，不占内存）

 - /proc  Processes 正在运行的内核信息映射，主要包括进程信息、内存资源信息、磁盘分区信息等。（虚拟文件系统，不占内存）

### 分区3：用户分区

/home  Home 除root用户之外其他用户的home目录。



### 分区4：交换分区

swap  Swap 交换分区、虚拟内存，一般为物理内存的1.5~2倍。