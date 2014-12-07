ActionSheet For Android
===========
这里先说明下，我是在做一个项目的时候需要ActionSheet，就在github上面找到了一个安卓方面的ActionSheet,[地址](https://github.com/baoyongzhang/ActionSheetForAndroid/tree/master/code),这里我感谢这位作者虽然我没有联系他，
我的这个ActionSheet是在他的这个基础上面修改的，他的效果是只是放了文字，我添加了图标和效果，而且我移除了原作者的style.xml文件和自定义的attr.xml这两个文件，我觉得一个控件就尽量的做到让使用者进少量的配置文件，如果可以最好是漏出相应的方法来进行设置，这也可能是我用其他语言的习惯吧，
这里在说明一点，我刚做安卓大概也就这2个礼拜，所以很多知识都是边学边做的，所以代码方面可能不是很完善，如果你看到了，可以告诉我我进行修改大家共同进步。

# 使用方法

### 在某个按钮点下的时候创建一个ActionSheet并显示

在使用之前请先复制`drawable`文件夹下的五个文件到你的项目里面，这五个是必须的
`actionsheet_bottom_border.xml`
`actionsheet_cancel_border.xml`
`actionsheet_middle_border.xml`
`actionsheet_single_border.xml`
`actionsheet_top_border.xml`

```java

//建立取消选项
Item cancelItem = new Item(R.color.white, R.color.bgred, 0, 0,
	R.color.actionsheet_cancel_color, R.color.white, "Cancel");

//建立内个单独的选项
Item item1 = new Item(R.color.white, R.color.bgred,
	R.drawable.setting_normal, R.drawable.setting_pressed,
	R.color.bgred, R.color.white, "Setting");
Item item2 = new Item(R.color.white, R.color.bgred,
	R.drawable.chrome_normal, R.drawable.chrome_pressed,
	R.color.bgred, R.color.white, "Chrome");
Item item3 = new Item(R.color.white, R.color.bgred,
	R.drawable.play_normal, R.drawable.play_pressed, R.color.bgred,
	R.color.white, "Play");

ActionSheet.createBuilder(this, this.getFragmentManager())
	.setCancelItem(cancelItem)
	.setmOtherItems(item1, item2, item3)
	.setCancelableOnTouchOutside(true).setListener(this).show();
```

### Item说明

每个Item在实例化的时候有两种方式，一种是加透明度，一种不添加
```java
Item item1 = new Item(R.color.white, R.color.bgred,
	R.drawable.setting_normal, R.drawable.setting_pressed,
	R.color.bgred, R.color.white, "Setting");


Item item2 = new Item(R.color.white, R.color.bgred,
	R.drawable.setting_normal, R.drawable.setting_pressed,
	R.color.bgred, R.color.white, "Setting", 0.7f);
```
第一个参数表示：背景默认的颜色
第二个参数表示：按下的时候背景的颜色
第三个参数表示：默认Icon的图标
第四个参数表示：按下时Icon的图标
第五个参数表示：默认文字的颜色
第六个参数表示：按下时文字的颜色
第七个参数表示：显示的文字
第八个参数表示：Item的背景透明度

### 方法说明

* `getIconMarginLeft()` 设置Item中图标距离左边的距离，如果你输入3就表示距离左边的距离是整个屏幕宽度的1/3
* `setmTextSize()` 设置整个ActionSheet中的字体大小
* `setmCancelButtonMarginTop()` 设置取消按钮的MarginTop值
* `setmOtherItemSpacing()` 设置每个Item之间的距离		
* `setCancelItem()` 设置取消按钮
* `setmOtherItems()` 设置Item
* `setCancelableOnTouchOutside()` 设置点击空白处关闭
* `setListener()` 设置事件监听器
* `show()` 返回`ActionSheet`对象，可以调用`ActionSheet`对象的`dismiss()`方法手动关闭

### 事件监听

实现`ActionSheetListener`接口
* `onOtherButtonClick()` 点击某个条目，`index`是条目的下标
* `onDismiss()` 关闭事件，`isCancel` 参数表示是否是点击取消按钮、返回键、或者点击空白处(`setCancelableOnTouchOutside(true)`)

```java
   	@Override
	public void onOtherButtonClick(ActionSheet actionSheet, int index) {
		Toast.makeText(getApplicationContext(), "click item index = " + index,
				0).show();
	}

	@Override
	public void onDismiss(ActionSheet actionSheet, boolean isCancle) {
		Toast.makeText(getApplicationContext(), "dismissed isCancle = " + isCancle, 0).show();
	}
```

### 样式

这里的样式都是可以在实例化Item的时候确定, 如果你觉得不能满足你的需求你也可以修改代码一边满足自己的需求。


