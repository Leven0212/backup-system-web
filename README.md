# backup-system-web

## 版本
### - v1 环境准备
  - v1.0 创建网站项目
  - v1.1 添加动态链接库.so文件，添加相关依赖
  - v1.2 创建调用.so文件的java库
  - v1.3 改用使用新进程调用算法库的方式

### - v2 网站前端
  - v2.1 导入前端模板
  - v2.2 修改相关配置
  - v2.3 调整前端板式
  - v2.4 完成界面设计
  - v2.5 添加校验功能
  - v2.6 结果自动刷新
  - v2.7 添加错误模版

### - v3 网站后端
  - v3.1 备份部分基本实现
  - v3.2 恢复和校验部分基本实现
  - v3.3 数据库存储备份方式完成
  - v3.4 实现算法库路径参数化 **(失败)**
  - v3.5 校验出错定位展示
  - v3.6 解决v3.4中的失败问题
  - v3.7 实现文件路径合法化
  - v3.8 实现错误结果的展示



==================================================

## TODO：
  - 调用算法前检查文件路径是否合法，如果最后以`“/”`结尾，则删去`“/”`  **=====解决=====**
  - 实现数据库的插入功能  **=====解决=====**
  - 将错误代码与文字提示绑定  **=====解决=====**
  - 解决特殊情况：用户选择不需要密码形式，但实际备份文件是加密的，此时现有程序没有检查密码，易导致出错。  **=====解决=====**
