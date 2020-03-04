## 安装

### 简介

:::tip
始于 [layui](https://layui.com) 的一个多选解决方案。<br/>
前身 [formSelects](https://github.com/hnzzmsf/layui-formSelects/), 由于渲染速度慢, 代码冗余, 被放弃了<br/>
[xm-select](https://gitee.com/maplemei/xm-select)使用了新的开发方式, 利用preact进行渲染, 大幅度提高渲染速度, 并且可以灵活拓展
:::

- 唯一依赖库[preactjs](https://preactjs.com/)
- 打包方式[webpack](https://www.webpackjs.com/)
- 文档借鉴于[ElementUI](https://element.eleme.cn/#/zh-CN)的编写方式
- [Fly社区交流贴](https://fly.layui.com/jie/57776/)
- xm-select技术群①: `660408068` (500人已满)
- xm-select技术群②: `938624691` (500人)
- 群满了加不进去的话 有问题就提 [issues](https://gitee.com/maplemei/xm-select/issues) 吧

### 作者

maplemei, 热爱前端的Java程序猿, 如果喜欢作者的插件, 可以请作者吃雪糕 ^_^

### 打赏

喜欢就支持一下吧

<p>
	<a href="javascript:;">
		<img src="../assets/wx.jpg" alt="打赏" width="300" style="border: 1px solid #EFEFEF">
	</a>
</p>



### 下载

| star | fork | download |
| -	   | - 	  | - 		 |
| [![star](https://gitee.com/maplemei/xm-select/badge/star.svg?theme=dark)](https://gitee.com/maplemei/xm-select/stargazers) | [![fork](https://gitee.com/maplemei/xm-select/badge/fork.svg?theme=dark)](https://gitee.com/maplemei/xm-select/members) | [码云下载](https://gitee.com/maplemei/xm-select/releases) | 


### 二次开发

```
$ git clone https://gitee.com/maplemei/xm-select.git
$ cd xm-select
$ npm install && npm run dev
```


### Hello World

```
第一步: 下载
第二步: 引入 xm-select.js
第三步: 写一个`<div id="demo1"></div>`
第四步: 渲染
	var demo1 = xmSelect.render({
		el: '#demo1',
		language: 'zn',
		data: [
			{name: '张三', value: 1},
			{name: '李四', value: 2},
			{name: '王五', value: 3},
		]
	})
```

:::demo 只需引入`xm-select.js`
```html
<div id="demo1" class="xm-select-demo"></div>
<button class="btn" id="demo1-getValue">获取选中值</button>
<pre id="demo1-value"></pre>

<script>
var demo1 = xmSelect.render({
	el: '#demo1', 
	language: 'zn',
	data: [
		{name: '张三', value: 1},
		{name: '李四', value: 2},
		{name: '王五', value: 3},
	]
})

document.getElementById('demo1-getValue').onclick = function(){
	//获取当前多选选中的值
	var selectArr = demo1.getValue();
	document.getElementById('demo1-value').innerHTML = JSON.stringify(selectArr, null, 2);
}
</script>

```
:::
