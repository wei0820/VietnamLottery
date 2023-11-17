// Generated by view binder compiler. Do not edit!
package com.tools.payhelper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tools.payhelper.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ThridloginDialogLoadingBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout dialogView;

  @NonNull
  public final ImageView img;

  @NonNull
  public final TextView tipTextView;

  private ThridloginDialogLoadingBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout dialogView, @NonNull ImageView img, @NonNull TextView tipTextView) {
    this.rootView = rootView;
    this.dialogView = dialogView;
    this.img = img;
    this.tipTextView = tipTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ThridloginDialogLoadingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ThridloginDialogLoadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.thridlogin_dialog_loading, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ThridloginDialogLoadingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout dialogView = (RelativeLayout) rootView;

      id = R.id.img;
      ImageView img = rootView.findViewById(id);
      if (img == null) {
        break missingId;
      }

      id = R.id.tipTextView;
      TextView tipTextView = rootView.findViewById(id);
      if (tipTextView == null) {
        break missingId;
      }

      return new ThridloginDialogLoadingBinding((RelativeLayout) rootView, dialogView, img,
          tipTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
