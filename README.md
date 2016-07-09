# retrofitMVP
尝试着retrofit与mvp的封装
使用方法
1、在你的Application类初始化Mosl.init（context,"你的请求域名地址",header），header为Map<String,Object>类型，可为空;
2、activity继承PresenterActivity，并指定presenter的泛型类型
3、presenter继承BasePresenter，并指定model,view的泛型类型
4、Model须继承IBaseModel,View须继承IBaseView
具体请参照APP中的demo
