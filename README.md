## backup-system-web

### 版本
#### - v1 环境准备
  - v1.0 创建网站项目
  - v1.1 添加动态链接库.so文件，添加相关依赖
  - v1.2 创建调用.so文件的java库
  - v1.3 改用使用新进程调用算法库的方式

#### - v2 网站前端
  - v2.1 导入前端模板
  - v2.2 修改相关配置
  - v2.3 调整前端板式
  - v2.4 完成界面设计
  - v2.5 添加校验功能
  - v2.6 结果自动刷新
  - v2.7 添加错误模版

#### - v3 网站后端
  - v3.1 备份部分基本实现
  - v3.2 恢复和校验部分基本实现
  - v3.3 数据库存储备份方式完成
  - v3.4 实现算法库路径参数化 **(失败)**
  - v3.5 校验出错定位展示
  - v3.6 解决v3.4中的失败问题
  - v3.7 实现文件路径合法化
  - v3.8 实现错误结果的展示
  - v3.9 解决了文件路径合法性校验遗漏问题，解决了校验时需要密码问题，解决了空路径或空密码问题
  - v3.10 解决了目前已知的bug。
  - v3.11 添加环境配置指南



==================================================

### TODO：
  - 调用算法前检查文件路径是否合法，如果最后以`“/”`结尾，则删去`“/”`  **=====解决=====**
  - 实现数据库的插入功能  **=====解决=====**
  - 将错误代码与文字提示绑定  **=====解决=====**
  - 解决特殊情况：用户选择不需要密码形式，但实际备份文件是加密的，此时现有程序没有检查密码，易导致出错。  **=====解决=====**
  - 在写入和读取数据库前检查路径合法性，即最后有无`“/”`结尾，并进行处理  **=====解决=====**
  - 校验时需要使用密码，需读取数据库来获得  **=====解决=====**
  - 解决当用户输入文件路径为空或密码为空时报错问题  **=====解决=====**

### 执行方法：
#### 生成 `jar` 包
手动克隆代码库并将网站源码打成 `jar` 包，或直接下载已打包好的 `jar` 包
##### 下载代码并打包
```shell
# 下载代码库并进行打包
> git clone https://github.com/Leven0212/backup-system-web.git
> mv backup-system-web-master backup-system-web
> cd backup-system-web
> mvn clean package
```
待出现 `build success` 即可，如下图所示：
![img.png](https://raw.githubusercontent.com/Leven0212/picture-club/main/202211081754823.png)

##### 直接下载已打包好的 `jar` 包
```shell
> wget https://raw.githubusercontent.com/Leven0212/backup-system/master/backup-system-web-0.0.1-SNAPSHOT.jar
```
#### 配置Java环境和MongoDB环境
`Java`版本 >= 1.8 \
`MongoDB`版本 >= 3.6

```shell
# 下载 Java 环境
> sudo apt install openjdk-8-jdk
# 下载 MongoDB 环境
> sudo apt install mongodb
```
* 如果要手动执行代码打包，还需配置`maven`环境
```shell
> sudo apt install maven
```