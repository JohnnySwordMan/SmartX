## 版本历程  
### v1.0.0  
1. 调整网络请求方法的位置，将网络请求从*onResume*中移动到*initData*和*initView*中，减少不必要的请求。（完成）
2. 自定义网络错误页面，在无网络的情况下，显示网络错误页面，提高用户体验。(完成)
3. 仿照微信，添加我的页面。
4. 添加注册、登录、收藏等功能。
	+ 10.18，已经完成注册、登录功能，接下来就是我的页面的展示。
5. BasePresenter需要修改。
6. 升级RxJava (已经完成，将RxJava1全部提成RxJava2)
7. 后续，将可以使用Lambda的地方，替换成Lambda

### v1.1.0
1. 日志与埋点。
2. 进入页面显示loading框、静默加载。
3. RxJava--->RxJava2

