package com.sportswork.sportswork.core.help;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/27 22:05
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Menu implements Serializable {
    //编号
    private String id;
    //菜单名
    private String name;
    //父菜单编号
    private String parentId;
    //菜单级别
    private int level;
    //地址
    private String url;
    //顺序
    private int order;
    //备注
    private String remarks;
    //孩子结点
    private List<Menu> children;

    public void addChildren(Menu menu){
        children.add(menu);
    }

//    public String toString(){
//        StringBuilder code = new StringBuilder();
//        if(id == null){
//            code.append("[");
//        } else{
//            code.append("{")
//                    .append("name:").append(name).append(",")
//                    .append("level:").append(level).append(",")
//                    .append("url:").append(url).append(",")
//                    .append("order:").append(order).append(",")
//                    .append("children:[");
//        }
//        for(Menu menu : children){
//            code.append(menu.toString());
//        }
//        code.append("]");
//        if(id != null){
//            code.append("}");
//        }
//        return code.toString();
//    }
}
