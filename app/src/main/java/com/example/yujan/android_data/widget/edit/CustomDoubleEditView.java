package com.example.yujan.android_data.widget.edit;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Toast;

/**
 * 自定义输入框：数值大于或者等于0.01且为两位小数
 */
public class CustomDoubleEditView extends androidx.appcompat.widget.AppCompatEditText {
    public CustomDoubleEditView(Context context) {
        super(context);
    }

    public CustomDoubleEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s.toString())) {
                    return;
                }
                // 判断小数点后只能输入两位
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
                        setText(s);
                        setSelection(s.length());
                    }
                }
                //如果第一个数字为0，第二个不为点，就不允许输入
                if (s.toString().startsWith("0") && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        setText(s.subSequence(0, 1));
                        setSelection(1);
                        return;
                    }
                    if (s.toString().length() == 4) {
                        //针对输入0.00的特殊处理
                        if (Double.valueOf(s.toString()) < 0.01) {
                            Toast.makeText(context, "最小为0.01", Toast.LENGTH_SHORT).show();
                            setText("0.01");
                            setSelection(getText().toString().trim().length());
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
