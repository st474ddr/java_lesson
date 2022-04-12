## 解耦

* 概念:降低程式間的依賴關係

* 實際開發應做到:**編譯期不依賴，運行時才依賴** (編譯器不報錯、運行時才會有誤)

 *  　　 思路:
       1. 使用reflection建立object，避免使用new
       2. 通過讀取配置文件來獲取要建立的object之class name

* 方式

  * 工廠模式

    以往: ![image](https://user-images.githubusercontent.com/17706261/162916359-c579b45e-ef79-46ed-92bd-9feef5c1267a.png)

​				![image](https://user-images.githubusercontent.com/17706261/162916489-4d55f812-508a-464b-b304-3bc70bfd32c3.png)

​			改變: ![image](https://user-images.githubusercontent.com/17706261/162916607-da24e2d1-627d-4918-93fa-0464da9b502f.png)

![image](https://user-images.githubusercontent.com/17706261/162917452-f93c479a-61d9-453a-9631-f8b2e1a7ddd8.png)