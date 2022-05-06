## Spring

* IOC 用來解決程式間的耦合
* 核心容器中的Interface
  * ApplicationContext (較常用)
    * 三個常見 implements class
      * ClassPathXmlApplicationContext: 載入**class path**下的配置文件
      * FileSystemXmlApplicationContext: 載入**硬碟任意路徑**下的配置文件
      * AnnotationConfigApplicationContext: 用來讀取註解建立容器
    * 特點
      * 建立object時是採取立即載入=>只要一讀取完就馬上建立配置文件中的配置object => 適用**單例**object
  * BeanFactory
    * 特點
      * 建立object時是採取延遲載入=>根據id獲取object時，才真正的建立object => 適用**多例**object