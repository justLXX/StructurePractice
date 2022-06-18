
[ 视频地址 ]( https://www.bilibili.com/video/BV13g41157hK?p=4&vd_source=1d5a23538746f4ecd22551b37527db7d )


[文档地址]( https://rujxcubsxu.feishu.cn/docx/doxcn8fW3v8BggyEoA2OB7phpQc )


## 递归
- 递归过程本质是压栈操作。（树的后序遍历）
- 递归重点一个是寻找结束条件，另一个是寻找递归部分
```java
class 递归 {
    /// 获取中点多方式 依次优化
    int mid = (L + R)/2;  // 不够严谨因为当数组过大时可能溢出
    int mid = L + (R - L)/2;
    int mid = L + (R-L)>>1;
}
```

## 归并
将数组划分为 < target 和 >= target 两部分

[参考 P4划分区域.kt 文件]( P4划分区域.kt )


## 快排
[文档]( https://rujxcubsxu.feishu.cn/docx/doxcn8fW3v8BggyEoA2OB7phpQc#doxcn80ScEWoSeoGQW9OWu9eWdb)

[Code](P4快排.kt)


## 堆排序
[文档](https://rujxcubsxu.feishu.cn/docx/doxcn8fW3v8BggyEoA2OB7phpQc#doxcnE6OUwmCKYiGuW6LczyErSf)

[code](P4堆排序.kt)
