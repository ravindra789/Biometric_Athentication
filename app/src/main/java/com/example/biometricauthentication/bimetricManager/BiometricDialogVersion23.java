package com.example.biometricauthentication.bimetricManager;

import android.app.DialogFragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.biometricauthentication.R;


/**
 * Created by RavindraP on 12,July,2019
 */
public class BiometricDialogVersion23 extends DialogFragment implements View.OnClickListener {

    private Context context;

    private Button btnCancel;
    private ImageView imgLogo;
    private TextView itemTitle, itemDescription, itemSubtitle, itemStatus;
    private String title, subtitle, description, negativeButtonText;

    private BiometricCallback biometricCallback;

    public BiometricDialogVersion23() {}

    public static BiometricDialogVersion23 newInstance(@NonNull Context context, BiometricCallback biometricCallback, String title, String subtitle, String description, String negativeButtonText) {
        BiometricDialogVersion23 fragment = new BiometricDialogVersion23();
        fragment.setData(context, biometricCallback, title, subtitle, description, negativeButtonText);
        return fragment;
    }

    private void setData(Context context, BiometricCallback biometricCallback, String title, String subtitle, String description, String negativeButtonText){
        this.context = context;
        this.biometricCallback = biometricCallback;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.negativeButtonText = negativeButtonText;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bimetric_dialog, container, false);

        btnCancel = view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);

        imgLogo = view.findViewById(R.id.img_logo);
        itemTitle = view.findViewById(R.id.item_title);
        itemStatus = view.findViewById(R.id.item_status);
        itemSubtitle = view.findViewById(R.id.item_subtitle);
        itemDescription = view.findViewById(R.id.item_description);

        itemTitle.setText(title);
        itemSubtitle.setText(subtitle);
        itemDescription.setText(description);
        btnCancel.setText(negativeButtonText);

        updateLogo();

        return view;
    }

    public void updateStatus(String status) {
        itemStatus.setText(status);
    }

    private void updateLogo() {
        try {
            Drawable drawable = getContext().getPackageManager().getApplicationIcon(context.getPackageName());
            imgLogo.setImageDrawable(drawable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        dismiss();
        biometricCallback.onAuthenticationCancelled();
    }
}
