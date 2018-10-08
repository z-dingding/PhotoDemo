package com.hxzk.bj.photodemo.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by ${赵江涛} on 2018-5-16.
 * 作用:
 */

public class BottomSheetDialogUtil {


    private static volatile BottomSheetDialogUtil sBottomSheetDialogUtil;
    private static Context mContext;

    private BottomSheetDialogUtil() {
    }


    //通过volatile关键字来确保安全，使用该关键字修饰的变量在被变更时会被其他变量可见
    private static volatile BottomSheetDialog mBottomSheetDialog;
    private static View botomSheetDialogView;

    public static BottomSheetDialogUtil getInstance(Context context, int layoutId) {
        mContext = context;

        if (sBottomSheetDialogUtil == null) {
            synchronized (BottomSheetDialogUtil.class) {
                sBottomSheetDialogUtil = new BottomSheetDialogUtil();
            }

        }
        if (botomSheetDialogView == null) {
            synchronized (BottomSheetDialogUtil.class) {
                botomSheetDialogView = LayoutInflater.from(mContext).inflate(layoutId, null);
                mBottomSheetDialog = new BottomSheetDialog(mContext);
                mBottomSheetDialog.setContentView(botomSheetDialogView);
            }
        }

        return sBottomSheetDialogUtil;
    }


    public static void showBottomSheetDialog() {
        if(!((Activity)mContext).isFinishing() && mBottomSheetDialog != null){
            mBottomSheetDialog.show();
        }

    }

    public static void dismissBottomSheetDialog() {
        if(botomSheetDialogView != null){
            botomSheetDialogView = null;
        }
        mBottomSheetDialog.dismiss();
    }


    public static BottomSheetDialog getmBottomSheetDialog() {
        if (mBottomSheetDialog != null) {
            return mBottomSheetDialog;
        }
        return null;
    }


    public static View getBottomSheetDialogView() {
        if (botomSheetDialogView != null) {
            return botomSheetDialogView;
        }
        return null;
    }

}
