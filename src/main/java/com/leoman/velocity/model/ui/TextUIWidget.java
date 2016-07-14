package com.leoman.velocity.model.ui;

import com.leoman.velocity.model.ValidateRule;

/**
 * Created by Administrator on 2016/6/22.
 */
public class TextUIWidget extends UIWidget{

    protected ValidateRule validateRule;     // 验证表达式
    protected String validateExpress;        // 自定义表达式

    public ValidateRule getValidateRule() {
        return validateRule;
    }

    public void setValidateRule(ValidateRule validateRule) {
        this.validateRule = validateRule;
    }

    public String getValidateExpress() {
        return validateExpress;
    }

    public void setValidateExpress(String validateExpress) {
        this.validateExpress = validateExpress;
    }

    @Override
    public String getWidgetText() {
        return "text";
    }
}
