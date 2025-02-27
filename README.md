# keycloak-services-social-weixin

[🇺🇸 English](README_en-US.md) | **[🇨🇳 简体中文](README.md)**

> 感谢原作者Jeff-Tian的开源项目，本项目是在原项目的基础上进行了一些修改，主要是适配了quay.io/keycloak 26.0版本。
> Keycloak 的微信登录插件，尝试在 Keycloak 里打通整个微信生态。相关文章：《[对接微信登录的三种方式 - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/659232648)》

![Java CI with Maven](https://github.com/Jeff-Tian/keycloak-services-social-weixin/workflows/Java%20CI%20with%20Maven/badge.svg)
[![Maven Package](https://github.com/Jeff-Tian/keycloak-services-social-weixin/workflows/Maven%20Package/badge.svg)](https://github.com/Jeff-Tian/keycloak-services-social-weixin/packages)

## 在线体验

- [点击我，右上角点击登录，然后选择使用微信登录](https://keycloak.jiwai.win/realms/Brickverse/account/#/ )

## 如何使用

本项目是一个 Keycloak 的插件，所以你需要先有一个 Keycloak 实例，然后把本项目打包成 jar 包，放到 Keycloak 的 providers 目录下，然后重启 Keycloak 即可。即：

* Add the jar to the Keycloak server:
    * `cp target/keycloak-services-social-weixin-*.jar _KEYCLOAK_HOME_/providers/`

* 在生产环境下的keycloak，需要执行kc.sh build 注册provider

## 👨‍💻 本地开发

需要 JDK 17 或者以上。

```shell script
mvn install
```

::: tip

如果在本地碰到比如编译出错等问题，最简单的办法就是使用 GitHub CodeSpace，绕过环境问题。

![](./assets/dev-container.jpg)

以上就是我在 CodeSpace 里开发本项目的截图，其开发容器配置在[这里](./.devcontainer/devcontainer.json)。

:::

### 如何调试？

我一般都是通过添加日志，然后重启 Keycloak 服务，然后查看日志来排查问题。

原因是这并不是一个独立的程序，无法通过 IDE 直接运行或者调试（找不到 Main class）。它是嵌入在 Keycloak 里，通过 Keycloak 的 SPI 机制来运行的。我一般都是通过 Docker 方式启动 Keycloak 或者直接将该包加载到服务器上的 Keycloak 实例，然后观察本地或者服务器端的日志输出来排查问题的。

如果有人知道如何在 IDE 中本地调试 Keycloak 的 SPI 插件，欢迎提供帮助！

## 跑测试

```shell script
mvn clean test
```

## Maven 包

[![](https://go.inversify.cn/api/dynamicimage?url=https://resume.jijiyy.me/zh-CN/jeff-tian/linked-in&width=332&height=242&version=v2)](https://www.linkedin.com/in/jeff~tian/)

我本是一名 JavaScript 程序员，使用 NodeJs 两年之后，就在 npm 上发布了 20 多个包。当开始折腾 Java 之后，也想在 Maven Central 中发布包，但折腾了很久之后，我放弃了——没想到这么复杂！发布到 Maven Central 的好处是可以方便其他项目在 pom.xml 中引用此包，所以还是有价值的，如果有谁知道怎么发布到 Maven Central，**请提供帮助**！

> 你也可以直接 fork 本仓库，并将它发布到 Maven Central，善莫大焉。

目前我在 GitHub 上发布了，在 GitHub 发布后，如果要在 pom.xml 中引用，不仅需要在 pom.xml 中配置 GitHub Packages 的仓库地址，还需要一个访问令牌，有一些麻烦。

当然，你也可以直接下载 jar 包：

- 支持 jboss/keycloak 16，你可以使用我打的包：https://github.com/Jeff-Tian/keycloak-services-social-weixin/packages/225091
- 支持 quay.io/keycloak 18.0.2 的代码版本：https://github.com/Jeff-Tian/keycloak-services-social-weixin/tree/8069d7b32cb225742d7566d61e7ca0d0e0e389a5
- 支持 quay.io/keycloak 21.1 的版本：https://github.com/Jeff-Tian/keycloak-services-social-weixin/tree/dev-keycloak-21
- 支持 quay.io/keycloak 22 的版本： https://github.com/Jeff-Tian/keycloak-services-social-weixin/tree/dev-keycloak-22
- 支持 quay.io/keycloak 26 的版本： 


## 获取 jar 包

### 直接下载

你可以从 https://github.com/Jeff-Tian/keycloak-services-social-weixin/packages 获取已经打好的 jar 包，可以省去打包的步骤。

### 手动打包

如果需要自己手动打包，可以在本地命令行执行：

```shell
mvn package
ls target
```

### 自动打包

本项目使用 GitHub Actions 自动打包，只需要在 master 分支上提交代码，即可自动打包。但是注意，需要修改 pom.xml 中的版本号，否则打包出来的 jar 包版本号和已经打好的 jar 包版本号冲突，从而不能上传到 GitHub Packages。

## 发版

本项目使用 GitHub Actions 自动发版，只需要在 master 分支上打一个 tag，然后在 GitHub 上发布一个 release 即可。不过，一般来说，也不需要手动打 tag。每次提交代码到 master 分支，GitHub Actions 都会检测是否有版本号的变化。如果版本号发生了变化，就会自动将该版本号做为新的 tag，并基于此来发布一个 release。详见： [这个 yml 文件](.github/workflows/release.yml) 。

## 版本更新

当需要更新本项目的版本时，需要修改 pom.xml 中的版本号。或者使用如下命令，比如将版本号改为 0.5.14：

```shell
mvn versions:set -DnewVersion=0.5.14
```

## 配置截图

### Keycloak 16

![image](https://user-images.githubusercontent.com/3367820/82117152-fdfd0300-97a0-11ea-8e10-02c9d9838a0a.png)

### Keycloak 22

![](./assets/config.png)

Client ID 和 公众号 App Id；Client Secret 和 公众号 App Secret 都可以是一样的，即通过手机或者 PC 的微信登录时，都使用同一个公众号。但是以上截图用了两个不同的，其中公众号 App Id 使用了我的个人测试公众号，在关注人数在 100 以内时可以使用。而手机端，则必须使用经过认证的企业公众号（特别感谢知友 [hhhnnn](https://www.zhihu.com/people/hhhnnn-78) 帮我提供，没有该服务号我没法调通手机端）。

## Docker 镜像

我也打包了一个包含[微信 idp 的 keycloak server docker 镜像](https://hub.docker.com/repository/docker/jefftian/keycloak-heroku)：
我补充了一个包含[微信 idp 的 keycloak server docker 镜像](https://hub.docker.com/r/monsterlin2024/keycloak-heroku)：

```shell script
docker pull jefftian/keycloak-heroku:latest

docker pull monsterlin2024/keycloak-heroku:26.0-wx0.6
```

## 一键部署

### 部署到 Heroku

点击这个按钮，可以部署一个包含微信登录的 Keycloak 到你自己的 Heroku：

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.svg)](https://dashboard.heroku.com/new?button-url=https%3A%2F%2Fgithub.com%2FJeff-Tian%2Fkeycloak-heroku&template=https%3A%2F%2Fgithub.com%2FJeff-Tian%2Fkeycloak-heroku)

::: warning 注意
Heroku 不再提供免费的 Dyno，部署到 Heroku 可能会产生费用。

![](./assets/heroku-bill.png)
:::

### 部署到 Okteto

[【免费架构】Heroku 不免费了，何去何从之 Keycloak 的容器化部署之路 - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/611823061)

## 谁在使用

| URL                        | 说明                                           | 源码                                           |
|----------------------------|----------------------------------------------|----------------------------------------------|
| https://keycloak.jiwai.win | 我部署在 heroku 上的 Keycloak 实例                   | https://github.com/jeff-tian/keycloak-heroku |
| https://www.da-yi-jia.com  | 感谢[答疑家](https://www.da-yi-jia.com)对本项目的大力支持！ |

## 💵 欢迎问我！

有任何相关问题，欢迎来知乎咨询：

<a href="https://www.zhihu.com/consult/people/1073548674713423872" target="blank"><img src="https://first-go-vercel.vercel.app/api/dynamicimage" alt="向我咨询"/></a>

## Release Notes

* 2022090
    - 适配 quay.io/keycloak 18.0.2

* 20180730
    - 增加自适应微信登录功能。
    - 账号关联默认使用微信unionid，如unionid不存在则使用openId
    - pc和wechat使用同一套账号则必须绑定同一个开放平台，否则会绑定不同账号
    - wechat信息非必填,默认使用pc方式登录

* 20200514
    - 增加 customizedLoginUrlForPc 功能。

* 20230820
    - 适配 quay.io/keycloak 21.1 的版本（由于 21 既不支持老的配置页，又没有新的方式增加自定义配置页，所以只能通过导入老的 Keycloak 版本中的 微信 identity provider 配置）

* 20230823
    - 适配 quay.io/keycloak 22.0.1 的版本，可以正常显示所有的配置了！[【重磅更新】关注微信公众号即登录插件升级支持 Keycloak 22！ - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/652167012) ![](./assets/config.png)
* 20230827
    - 新增对微信开放平台的支持。 [【继续更新】尝试在 Keycloak 里打通整个微信生态 - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/652566471)

* 20240129（[0.5.13](https://github.com/Jeff-Tian/keycloak-services-social-weixin/releases/tag/0.5.13)）
    - 优化关注公众号即登录方案的微信后台配置。 详见《[基于 Keycloak 的关注微信公众号即登录方案再次升级：有意思的成长 - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/680356153)》

* 20250227（[0.6.0]
    - 适配 quay.io/keycloak 26.0版本。由于keycloak 对类库org.keycloak.services.HttpRequestImpl进行修订，转而使用类库org.keycloak.quarkus.runtime.integration.resteasy.QuarkusHttpRequest。


## Star History

感谢大家的支持！

[![Star History Chart](https://api.star-history.com/svg?repos=Jeff-Tian/keycloak-services-social-weixin,jyqq163/keycloak-services-social-weixin&type=Date)](https://star-history.com/#Jeff-Tian/keycloak-services-social-weixin&jyqq163/keycloak-services-social-weixin&Date)

## 致谢

- 感谢 [jyqq163/keycloak-services-social-weixin](https://github.com/jyqq163/keycloak-services-social-weixin) 提供的基础代码，本仓库从该仓库 fork 而来。
- 感谢 [hhhnnn](https://www.zhihu.com/people/hhhnnn-78) 提供的企业公众号，没有该服务号我没法调通手机端。
- 感谢[各位](https://github.com/Jeff-Tian/keycloak-services-social-weixin/graphs/contributors)发的 pull request 和 issue，让本项目越来越好！

## 原理

其实任何一个 OAuth2/OIDC 的登录插件都是一样的，都是通过一个授权链接，然后通过 code 换取 access_token，再通过 access_token 换取用户信息。详见《[三步开发社交账号登录（以钉钉登录举例） - Jeff Tian的文章 - 知乎](https://zhuanlan.zhihu.com/p/666423994) 》

### 以开放平台微信登录举例

#### 先构建授权链接

链接如下：

```
https://open.weixin.qq.com/connect/qrconnect?scope=snsapi_login&state=d3Yvfou3pdgp-UNVZ-i7DTDEbv4rZTWx6Wh7lmxzyvk.98VO-haMdj4.c0L0bnybTEatKpqInU02nQ&response_type=code&appid=wxc09e145146844e43&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Frealms%2Fmaster%2Fbroker%2Fweixin%2Fendpoint
```

用户使用微信扫描以上链接中展示的二维码后，会跳转到微信的授权页面，用户点击同意后，会跳转到我们的回调地址，并且带上 code 和 state 参数，如下：

```
https://keycloak.jiwai.win/realms/master/broker/weixin/endpoint?code=011er8000zwPzQ1Fvw200DTBCP1er80K&state=d3Yvfou3pdgp-UNVZ-i7DTDEbv4rZTWx6Wh7lmxzyvk.98VO-haMdj4.c0L0bnybTEatKpqInU02nQ
```

#### 通过 code 换取 access_token

#### 通过 access_token 换取用户信息

## 🧧 [其他 Keycloak 社交登录插件](https://afdian.net/album/1270bba089c511eebb825254001e7c00)

- [钉钉登录](https://github.com/Jeff-Tian/keycloak-services-social-dingding)
- [企业微信](https://github.com/Jeff-Tian/keycloak-services-social-wechatwork)
