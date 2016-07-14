package com.leoman.velocity.model.ui;

/**
 * Created by Administrator on 2016/6/22.
 */
public class ImageUIWidget extends UIWidget{

    private boolean isMore; // 是否多选

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    @Override
    public String getWidgetText() {
        return "image";
    }
}
