package com.leoman.velocity.model.ui;

import com.leoman.velocity.core.ParamOption;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public class RadioUIWidget extends UIWidget{

    private List<ParamOption> list;

    public List<ParamOption> getList() {
        return list;
    }

    public void setList(List<ParamOption> list) {
        this.list = list;
    }

    @Override
    public String getWidgetText() {
        return null;
    }
}
