# # 编写高质量代码建议

## 基本类型
```text
建议21：用偶判断，不用奇判断

//模拟取余计算，dividend被除数，divisor除数
public static int remainder(int dividend,int divisor){
    return dividend - dividend / divisor * divisor;
}
对-1 % 2 时， 使用上述计算 = -1， 若结果用奇数判断则会报错


建议23：不要让类型默默转换
long dis2 = LIGHT_SPEED * 60 * 8;
long dis2 = 1L * LIGHT_SPEED * 60 * 8;

建议24：边界，边界，还是边界

建议25：不要让四舍五入亏了一方

```