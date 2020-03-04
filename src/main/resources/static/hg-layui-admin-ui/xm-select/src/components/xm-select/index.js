import { h, Component, render } from 'preact'
import { datas, optionData, childData } from '@/index.js';
import { warn, listenerClose, isArray, deepMerge, exchangeOptionsData } from '@/common/util'
import Framework from '@/components/framework'
import defaultOptions from '@/config/options'

class xmOptions {

	constructor(options) {
		this.init(options);
	}

	init(options){
		//定义默认值
		this.options = defaultOptions(options.language);
		//开始渲染数据
		this.update(options);
	}

	/**
	 * 更新数据 + 重新渲染
	 */
	update(options = {}){

		let updateData = !!options.data;

		//记录最新的配置项
		this.options = deepMerge(this.options, options);

		//如果dom不存在, 则不进行渲染事项
		let { dom } = this.options;
		if(!dom){
			warn(`没有找到渲染对象: ${options.el}, 请检查`)
			return ;
		}
		//判断data的数据类型
		let optionsData = this.options.data || [];
		if(typeof(optionsData) === 'function'){
			optionsData = optionsData();
			this.options.data = optionsData;
		}
		if(!isArray(optionsData)){
			warn(`data数据必须为数组类型, 不能是${ typeof(data) }类型`)
			return ;
		}

		render(<Framework { ...this.options } updateData={ updateData } />, dom);

		//返回多选对象
		return this;
	}

	/**
	 * 重置多选, 回到初始化的状态
	 */
	reset(){
		const { el } = this.options
		//重新渲染
		this.init(optionData[el]);
		//子组件初始化
		childData[el].init(this.options, true);
		return this;
	}

	/**
	 * 主动打开多选
	 */
	opened(){
		let ref = childData[this.options.el];
		!ref.state.show && ref.onClick();
		return this;
	}

	/**
	 * 主动关闭多选
	 */
	closed(){
		let ref = childData[this.options.el];
		ref.state.show && ref.onClick();
		return this;
	}

	/**
	 * 获取多选选中的数据
	 */
	getValue(type){
		let arr = childData[this.options.el].state.sels.map(item => {
			item = { ...item };
			delete item.__node;
			return item;
		});

		if(type === 'name'){
			return arr.map(item => item[this.options.prop.name]);
		}else
		if(type === 'nameStr'){
			return arr.map(item => item[this.options.prop.name]).join(',');
		}else
		if(type === 'value'){
			return arr.map(item => item[this.options.prop.value]);
		}else
		if(type === 'valueStr'){
			return arr.map(item => item[this.options.prop.value]).join(',');
		}

		return arr;
	}

	/**
	 * 设置多选数据
	 */
	setValue(sels, show, listenOn = false){
		if(!isArray(sels)){
			warn('请传入数组结构...')
			return ;
		}
		childData[this.options.el].value(this.options.radio ? sels.slice(0, 1) : sels, show, listenOn);
		return this;
	}

	/**
	 * 追加赋值
	 */
	append(sels){
		if(!isArray(sels)){
			warn('请传入数组结构...')
			return ;
		}
		childData[this.options.el].append(sels);
		return this;
	}

	/**
	 * 删除赋值
	 */
	delete(sels){
		if(!isArray(sels)){
			warn('请传入数组结构...')
			return ;
		}
		childData[this.options.el].del(sels);
		return this;
	}

	/**
	 * 闪烁警告边框
	 */
	warning(color, sustain = false){
		let showColor = color || this.options.theme.maxColor;

		sustain === true ? (
			childData[this.options.el].base.style.borderColor = showColor
		) : (
			childData[this.options.el].updateBorderColor(showColor)
		)
		return this;
	}

}

export default xmOptions;
