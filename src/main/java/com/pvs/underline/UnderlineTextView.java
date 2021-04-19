package com.pvs.underline;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class UnderlineTextView extends AppCompatTextView {
    private boolean ifTextChanged = false;
    public UnderlineTextView(Context context) {
        super(context);
        setListener();
    }

    public UnderlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setListener();
    }

    public UnderlineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setListener();
    }

    private void setListener() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!ifTextChanged)
                    underlineText();
            }
        });
        underlineText();
    }

    private void underlineText() {
        if (!ifTextChanged) {
            ifTextChanged = true;
            SpannableString spannableString = new SpannableString(getText());
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            setText(spannableString);
            ifTextChanged = false;
        }
    }
}
