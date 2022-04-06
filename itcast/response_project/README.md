## DEMO 

### response

1. 重新導向
   * 重新導向(redirect)特點
     1. url發生變化
     2. 可以訪問其他網站(server)資源
     3. **2**次請求
   * 轉發(forward)特點
     1. url不變
     2. 只能訪問當前server的資源
     3. **1**次請求，可以使用request物件
2. server輸出string數據到browser
   * 步驟
     1. 獲取string output stream
     2. output data
   * 注意
     * 亂碼問題
       1. `PrintWriter pw = resp.getWriter();` 採用的預設編碼來自Tomcat
       2. 設置stream default encoding
       3. 建議browser use encoding
3. server輸出byte數據到browser
   * 步驟
     1. 獲取byte output stream
     2. output data
4. 驗證碼
   * 目的:防止惡意表單註冊

### servletcontext

* 文件下載
  * 需求
    1. 顯示超連結
    2. 點擊超連結彈出下載提示
    3. 下載檔案
  * 分析
    1. 若browser能解析則會直接顯示；反之會有下載提示框
    2. 任何文件都應彈出下載提示 
       => 使用response header 設定打開方式:` content-disposition:attachment;filename=xxx`
  * 步驟
    1. href指向servlet處理
    2. 定義servlet
       1. 獲取檔名
       2. 使用byte input stream讀到memory
       3. 指定response的header
       4. 將data輸出