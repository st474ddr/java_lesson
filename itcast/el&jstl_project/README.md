## JSP

1. 指令
   * 格式: `<%@ 指令名稱 屬性名=屬性值 %>`
   * 分類:
     1. page : 配置jsp頁面
        * contentType : 等同 `response.setContentType()`
          * 設置response body的mime類型以及encoding
          * 設置目前的jsp頁面encoding (如果用低級IDE，需設定pageEncoding)
        * import : 導入包
        * errorPage : 當前頁面異常，後會自動跳轉到指定的錯誤頁面
        * isErrorPage : 識別當前頁面是否為錯誤頁面
          * true:可以使用 built-in object `exception`
     2. include: 用來包含頁面 `<%@ include file="top.jsp" %>`
     3. taglib :導入資源 `<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>`
        * prefix: 前綴，自定義

2. built-in object

   * jsp中不需要建立，可直接使用的object

   * 共9個

     ​		  變數名稱                                                                   實際class                                            功能

     * pageContext                                                            **PageContext**                            當前頁面資料共享
     * request                                                                **HttpServletRequest**          
     * session                                                                      **HttpSession**                   
     * application                                                             **ServletContext **                        所有user間共享資料
     * response                                                              **HttpServletResponse**
     * page                                                                                **Object**                          當前頁面(Servlet) => this
     * out                                                                                 **JspWriter**                                     輸出object
     * config                                                                        **ServletConfig**                              Servlet設定object
     * exception (聲明errorPage才可使用)                        **Throwable**

## MVC

1. jsp演變歷史
   1. 早期只有Servlet，只能用response輸出html標籤
   2. jsp產生，簡化Servlet開發
   3. 過度使用jsp，造成jsp中有一堆不同樣式code，難以維護分工
   4. java web 使用MVC開發模式
2. 概念
   * M => JavaBean
   * V => JSP
   * C => Servlet
3. 優缺點
   * 優點:
     * 耦合性低，方便維護、利於分工
     * 重複使用性高
   * 缺點:
     * project架構複雜

## EL表達式 (Expression Language)

1. 概念: 替換和簡化jsp頁面的java code
2. 語法: ${表達式}
3. 說明:
   * jsp 預設支援el表達式
     * 可在page中設定 `isELIgnored` 為 `true`，讓整個頁面el失效
     * 或使用`\${}` 來呈現脫逸單個el表達式

4. 使用
   * 只能從fiedl object 取值
   * 語法:
     1. ${`field_name`.`key_name`}
        * field_name:
          1. pageScope             --> pageContext
          2. requestScope        --> request
          3. sessionScope         --> session
          4. applicationScope  --> application (ServletContext)
        * 例:`${requestScope.name}`
     2. ${`key_name`}: 從最小的field開始找是否有該key，直到找到
     3. 獲取object, list, map之值
        1. object: `${field_name.key_name.property_name}`
           * 實際是呼叫getter方式
        2. list:  `${field_name.key_name[index]}`
        3. map: `${field_name.key_name}`  or  `${field_name[key_name]}`
   * implicit object
     * 有11個
     * pageContext:
       * 獲取jsp其他8個built-in object
         * `${pageContext.request.contextPath}`

## JSTL (JavaServer Pages Tag Library)

1. 由Apache提供的開源免費jsp標籤
2. 作用:用於簡化和替換jsp的java code
3. 使用步驟:
   1. 導入jar包
   2. 引入tag library: taglib指令
   3. 使用tag
4. 常用
   1. if                => 相當於java的if
      * test 為必須屬性，接受boolean，代表是否顯示
        一般情況下會結合el表達是一起使用
      * 沒有else情況，只能再多使用if
   2. choose      => 相當於java的switch
   3. foreach     => 相當於java的for
      * 屬性:
        * begin:起始值
        * end:結束值
        * var:臨時變數 (`i`)
        * step: 改變幅度
        * items: 遍歷list使用
        * varStatus: 狀態object
          * index: 當前元素的索引, 從0開始
          * count: 當前元素的循環次數, 從1開始

