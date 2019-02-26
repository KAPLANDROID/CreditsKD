package com.ahitaf.creditskd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CreditsDialog extends Dialog {

    @SuppressWarnings("ConstantConditions")
    public CreditsDialog(final Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_credits);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        LinearLayout llCreditsLogoRoot = findViewById(R.id.llCreditsRoot);

        final ImageView ivCreditsLogo = findViewById(R.id.ivCreditsLogo);

        FrameLayout.LayoutParams mLP = new FrameLayout.LayoutParams(
                context.getResources().getDisplayMetrics().widthPixels,
                context.getResources().getDisplayMetrics().heightPixels);

        llCreditsLogoRoot.setLayoutParams(mLP);

        setCanceledOnTouchOutside(false);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(ivCreditsLogo, "alpha", 0, 0.25f, 1),
                ObjectAnimator.ofFloat(ivCreditsLogo, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(ivCreditsLogo, "rotationY", 0, 360),
                ObjectAnimator.ofFloat(ivCreditsLogo, "rotation", 0, 360),
                ObjectAnimator.ofFloat(ivCreditsLogo, "alpha", 1, 0.25f, 1)
        );

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(ivCreditsLogo, "alpha", 1, 0.25f, 1);
                anim.setDuration(3000);
//                anim.setRepeatCount(ValueAnimator.INFINITE);
//                anim.setRepeatMode(ValueAnimator.REVERSE);

                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        CreditsDialog.this.dismiss();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });


                anim.start();
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.setDuration(5 * 1000).start();


    }
}
