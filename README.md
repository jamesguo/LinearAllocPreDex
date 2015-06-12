## 使用说明
### 1，创建DexClassLoader
    DexClassLoader classLoader = new DexClassLoader("目标apk路径", getApplicationInfo().dataDir, null,this.getClass().getClassLoader());
### 2，将apk文件解压，提取classes.dex文件，并push到设备
### 3，调用校验方法
    CheckDex.checkPreDexInfo(new String("classes.dex的文件路径"),new String("中间文件输出路径"),classLoader);
### 4，日志查看
alloc size的差值在**460万以下（此为经验值，可能会再降低）**为安全值


由于各个设备ROM的差异，初始时加载的jar个数种类均有差异，空白应用所需的大小不一，导致5M无法全部被应用使用
```
D/dalvikvm-CheckPreDex﹕ Loaded DEX file before alloc size = 3330900  loadedClasses count = 3465
D/dalvikvm-CheckPreDex﹕ Loaded DEX file after alloc size = 8806148 loadedClasses count = 12236
```

# Warning 
##### 1,**项目核心功能基于Android 4.4.2源码开发，兼容性未作测试，使用时尽量使用4.4.x的设备**
##### 2,**由于LinearAlloc的限制，每次启动只能使用一次，再次测试需杀死进程**