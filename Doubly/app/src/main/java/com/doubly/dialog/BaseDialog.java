package com.doubly.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * Created by tinyiota on 1/7/16.
 */
public class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
