一、定义

门面(外观)模式  要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更容易使用。

二、类型

结构型

三、适用场景

为一个复杂的模块或子系统提供一个供外部访问的接口。
子系统相对独立，外界对子系统的访问只要黑盒操作即可。
四、优点

减少系统的相互依赖，子系统只提供一个指定接口，防止外界系统深入到子系统内部，减少耦合。
提高灵活性，不管子系统内部如何变化，只要不影响门面对象，就没什么关系。
提高安全性，外界只能访问指定的业务，不在门面上提供的业务，休想访问。
五、缺点

违背开闭原则，增加子系统和扩展子系统的时候容易引入风险。