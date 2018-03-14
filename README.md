# DWStickItemDecoration

<img src="https://github.com/123ufo/DWStickItemDecoration/blob/master/img/a.gif?raw=true" width="280"/>


## 使用方式只需两步

## 第一步:
##### Gradle compile dependency:

        	compile 'com.ufo:DWStickItemDecoration:1.0.0'
## 第二步:

      RecyclerView recyclerView = findViewById(R.id.recycler_view);
      DWStickItemDecoration decoration = new DWStickItemDecoration(this) {
                @Override
                protected boolean isShowItemLabel(int position) {
                    //返回true表示要显示组的第一个item的标签
                    //看下面的模拟演示数据
                    return mList.get(position).isShowLable();
                }

                @Override
                protected String getItemLabelStr(int position) {
                    //返回标签的文本字符串
                    return mList.get(position).getSpell();
                }
            };
       recyclerView.addItemDecoration(decoration);


### 更多可设置相关参数:

            //设置标签颜色
    //        decoration.setLabelColor(Color.DKGRAY);
            //设置标签高度
    //        decoration.setLabelHeight(30);
            //设置标签字体颜色
    //        decoration.setTextColor(Color.RED);
            //设置标签字体大小
    //        decoration.setTextSize(50);
.

### 模拟演示数据

            list.add(new DataBean("阿狗", true, "A"));  //isShowIitemLabel()返回true  ;getItemLabelStr()返回A
            list.add(new DataBean("安智", false, "A"));//isShowIitemLabel()返回false ;getItemLabelStr()返回A
            list.add(new DataBean("爱", false, "A")); //isShowIitemLabel()返回false ;getItemLabelStr()返回A
            list.add(new DataBean("操", true, "C"));    //isShowIitemLabel()返回true  ;getItemLabelStr()返回C
            list.add(new DataBean("成成", false, "C"));   //......
            list.add(new DataBean("陈百", false, "C"));
            list.add(new DataBean("陈百2", false, "C"));
            list.add(new DataBean("陈百3", false, "C"));
            list.add(new DataBean("陈百34", false, "C"));
            list.add(new DataBean("陈百345", false, "C"));
            list.add(new DataBean("家家", true, "J"));
            list.add(new DataBean("叫叫", false, "J"));
            list.add(new DataBean("杰杰", false, "J"));
            list.add(new DataBean("杰杰1", false, "J"));
            list.add(new DataBean("杰杰2", false, "J"));
            list.add(new DataBean("杰杰3", false, "J"));
            list.add(new DataBean("杰杰4", false, "J"));
            list.add(new DataBean("科", true, "K"));
            list.add(new DataBean("开门", false, "K"));
            list.add(new DataBean("阿凯", false, "K"));
            list.add(new DataBean("烟", true, "Y"));
            list.add(new DataBean("烟1", false, "Y"));
            list.add(new DataBean("烟2", false, "Y"));
            list.add(new DataBean("烟3", false, "Y"));
            list.add(new DataBean("烟4", false, "Y"));
            list.add(new DataBean("造4", true, "Z"));
            list.add(new DataBean("智4", false, "Z"));


### 更多细节请查看Demo里的代码.