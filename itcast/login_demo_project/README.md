## demo: 登入功能

### 需求

1. login.html 為登入頁面

   username & password 兩個輸入框

2. 使用Druid ，操作mysql.user table

3. 使用JdbcTemplate封裝JDBC

4. 登入成功 => SuccessServlet

   ​        失敗 => FailServlet

### 分析

![image](https://user-images.githubusercontent.com/17706261/161912396-52e1dd72-0ea1-495b-8225-03ae0b3e508e.png)



### jar包&版本

commons-logging-1.2.jar

druid-1.0.9.jar

mchange-common-java-0.2.12.jar

mysql-connector-java-5.1.37.bin.jar

spring-beans.5.0.0.RELEASE.jar

spring-core.5.0.0.RELEASE.jar

spring-jdbc.5.0.0.RELEASE.jar

spring-tx.5.0.0.RELEASE.jar

下載參考網址:https://www.findjar.com/

### 步驟

1. 建立project，配置文件、jar包
2. 建立Database相關資料
3. 建立loginServlet轉換動作
   * failServlet, successServlet供轉發
4. 使用BeanUtils，簡化數據封裝
   * 用於封裝JavaBean
     1. JavaBean:標準的Java class
        1. class 必須被public修飾
        2. 必須提供空參數的constructor
        3. 成員變數必須用private修飾
        4. 提供公用的setter和getter方法
     2. 功能:封裝數據
   * 概念:
     * 成員變數
     * 屬性:setter和getter方法得到的結果，通常跟成員變數一樣
       如: getUsername() --> Username --> username 
   * 方法:
     1. `setProperty()`  -> 設定**"屬性"**，非成員變數
     2. `getProperty()`  -> 拿取**"屬性"，非成員變數**
     3. `populate(Object obj, Map map)` -> 將map集合的key-value資訊封裝到對應JavaBean object中 

​						
