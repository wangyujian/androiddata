# androiddata
1）MVC/MVP/MVVM  
总结：  
* 1）如果项目简单，没什么复杂性，未来改动也不大的话，那就不要用设计模式或者架构方法，只需要将每个模块封装好，方便调用即可，不要为了使用设计模式或架构方法而使用。
* 2）对于偏向展示型的app，绝大多数业务逻辑都在后端，app主要功能就是展示数据，交互等，建议使用mvvm。
* 3）对于工具类或者需要写很多业务逻辑app，使用mvp或者mvvm都可以。
* 4）如果想通过一个项目去学习架构和设计模式，建议用MVC然后在此基础上慢慢挖掘改进。最后你可能发现，改进的最终结果可能就变成了mvp，mvvm。
