package com.virgo.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.virgo.myapplication.R;


/**
 * Created by Administrator on 2017/3/13.
 */
public class LoadingDialog extends DialogFragment {

    public interface DialogClickListener {
        void onClick();
    }

    private DialogClickListener mListener;

    public void setDialogClickListener(DialogClickListener listener) {
        this.mListener = listener;
    }


    public static LoadingDialog newInstance(String content) {
        LoadingDialog fragment = new LoadingDialog();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        final Dialog dialog = new Dialog(getActivity());
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_loading_dialog, null, false);
        TextView contentText = (TextView) view.findViewById(R.id.loading_text_content);
        ImageView cancleImage = (ImageView) view.findViewById(R.id.loading_image_cancle);
        String content = getArguments().getString("content");
        contentText.setText(content);


        if (mListener != null) {
            cancleImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    if (mListener != null) {
                        mListener.onClick();
                    }
                }
            });
        }
        dialog.setContentView(view);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.75), ViewGroup.LayoutParams.WRAP_CONTENT); //根据屏幕宽度设置 LoadingDialog 宽度 比例 0.75
        }
    }
}
