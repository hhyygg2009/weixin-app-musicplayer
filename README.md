# 音乐播放器-微信小程序

<p>
  <a href="https://github.com/hhyygg2009"><img src="https://img.shields.io/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-hhyygg2009-blue" alt="作者GITHUB"></a>
  <a href="https://gitee.com/hhyygg"><img src="https://img.shields.io/badge/%E7%A0%81%E4%BA%91-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-orange" alt="码云"></a>
</p>


## 项目介绍

​	本项目是为了在微信小程序上面实现音乐播放器的功能，其数据源自于线上的服务器，可以播放在线的音乐资源，是一个流媒体播放器。



## 已知BUG

微信小程官方SDK里面的播放组件，播放状态可能会不一致，可能导致音乐在播放时候，仍然显示播放按钮。



## 开发环境&使用的技术栈

前端是使用微信小程序

后端是使用 Java8+Servlet+JDBC+MySQL+FastJSON+Maven

建议部署环境Tomcat9，MySQL8.0.21

IDE：Ecplise2020



## 部署方法

1. 将/server/deploy内的musicplayer.war放入Tomcat中
2. 创建数据库，名为musicplayer
3. 将/server/db内的musicplayer.sql导入到数据库中
4. 用微信开发者工具部署微信小程序

默认用户名和密码为`admin`



## 实现的功能

1. 音乐“发现”页面

- 可搜索歌曲获得歌曲播放列表和歌曲有关信息
- “我的”页面

2. “播放”音乐

- 具有音乐播放的控制功能：播放、暂停、播放进度条（支持拖动）、快进等
- 点击收藏，可收藏该歌曲

3. 用户登录页面

- 注册用户
- 用户登录

4. 用户资料的显示和修改功能



## 演示效果截图

1. 首页

可搜索歌曲获得歌曲播放列表和歌曲有关信息

<img src="https://raw.githubusercontent.com/hhyygg2009/weixin-app-musicplayer/master/demo/1_1home.jpg"  width = "270" height = "480"/>

2. 音乐播放界面
具有音乐播放的控制功能：播放、暂停、播放进度条（支持拖动）、快进等
<img src="https://raw.githubusercontent.com/hhyygg2009/weixin-app-musicplayer/master/demo/1_2playlist.jpg"  width = "270" height = "480"/>

<img src="https://raw.githubusercontent.com/hhyygg2009/weixin-app-musicplayer/master/demo/1_3play.jpg"  width = "270" height = "480"/>

3. 我的音乐界面
	查看个人收藏的音乐，点击收藏，可收藏歌曲


<img src="https://raw.githubusercontent.com/hhyygg2009/weixin-app-musicplayer/master/demo/1_4mylist.jpg"  width = "270" height = "480"/>

