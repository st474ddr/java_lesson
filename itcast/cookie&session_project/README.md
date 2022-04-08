## 會話技術

1. 概念:一次會話中包含多次request和response
   * 一次會話:browser第一次給server發送request，會話建立，直到有一方斷開連接
2. 功能: 在一次會話的範圍內的多次request間，共享數據
3. 方式:
   1. client端: Cookie
   2. server端:Session

## Cookie

1. 概念:client的會話技術，將數據保存到client

2. 使用步驟:

   1. 建立Cookie object，綁定數據
      * `new Cookie(String name, String value)`
   2. 發送Cookie object
      * `response.addCookie(Cookie cookie)`
   3. 獲取Cookie，提取數據
      * `Cookie[] request.getCookies()`

3. 實現原理

   基於response header 中的set-cookie和request header 中的cookie實現

4. 細節

   1. 一次是否可發送多個cookie?

      可以建立多個Cookie對象

   2. cookie能在browser保存多久?

      1. 預設情況，當browser關閉, cookie數據即銷毀
      2. 持久化儲存:
         * `setMaxAge(int seconds)`
           1. 正數:將cookie數據寫到硬碟的文件中。 數字代表cookie存活時間(秒)
           2. 負數:預設值
           3. 0:刪除cookie訊息

   3. cookie是否能儲存中文?

      * tomcat 8 之前無法(需轉碼用urlencode)；之後的可以

   4. cookie的共享範圍?

      * 在一個tomcat server中，部署多個web project，那cookie是否能在這些project中共享?

        * 預設不能共享
        * `setPath(String path)`:設定cookie的存取範圍。預設為當前的虛擬目錄

      * 不同的tomcat server間cookie是否能共享

        * `setDomain(String path)`:如果一級域名相同，則多個server間可以共享

          如:`setDomain(".google.com")` 則news.google.com和search.google.com可共享

5. 特點
   1. cookie在client端browser儲存數據
   2. browser對單個cookie有大小限制(4kb)，對同一域名下的cookie數量也有限制
      * 作用:
        1. cookie用於存少量不敏感數據
        2. 不登入情形下，完成server對client端的身分識別

## JSP

1. 概念

   * Java Server Pages
     * java和html混合用的頁面
     * 簡化書寫功用

2. 原理: jsp 本質上就是一個servlet

   ![image](https://user-images.githubusercontent.com/17706261/162359373-85a0eee8-41b4-4a6a-a323-f7a60a66b88d.png)

3. JSP撰寫方式
   1. <%  code %> : 在service方法中，執行java相關操作
   2. <%! code %> : 在jsp轉換後的java class 成員變數
   3. <%= code %> : 在service方法中，會直接輸出

4. JSP的built-in object (可直接在jsp使用的object)
   * 共有9個
     1. request
     2. response
     3. out : string output stream object，可將數據輸出到頁面
        * 和response.getWriter()的差別
          * response永遠優先顯示，接著才是out

## Session

1. 概念: server端的會話技術，將數據保存到server

2. 使用步驟

   1. 獲取HttpSession object:

      `HttpSession session = request.getSession();`

   2. 使用HttpSession object:

      `Object getAttribute(String name)`

      `void setAttribute(String name)`

   `void removeAttribute(String name)`

3. 原理: session的實現是依賴於cookie
4. 細節
   1. 當client端關閉後，server不關閉，兩次獲取session是否同一個?
      * 預設不是，若需要相同，則可創建cookie以key為JSESSIONID設置setMaxAge，讓cookie持久化保存
   2. client端不關閉，server關閉，兩次獲取session是否同一個?
      * 否，但要確保數據不丟失
        * session的鈍化: 在server正常關閉前，將session object 序列化到硬碟上
        * session的活化: 在server啟動後，將硬碟的session文件轉化到memory中的session object
        * tomcat會自動提供此功能，server關閉時，session.seq會放在tomcat的**work**相關目錄中
   3. session的失效時限?
      1. server關閉
      2. session object 呼叫 `invalidate()`
      3. 預設30分鐘，可在tomcat的`web.xml`中`<session-config>`修改

5. 特點
   1. 用於儲存一次會話的多次請求之數據，存在server端
   2. session可以儲存任意類型，任意大小的數據