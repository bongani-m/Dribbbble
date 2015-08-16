package com.bonganimbigi.dribbble.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bonganimbigi.dribbble.R;
import com.bonganimbigi.dribbble.entity.Shot;
import com.bonganimbigi.dribbble.util.BundleKeys;
import com.bonganimbigi.dribbble.util.ColorUtil;
import com.bonganimbigi.dribbble.util.DribbblePicasso;
import com.squareup.picasso.Callback;

import butterknife.InjectView;

public class ShotActivity extends BaseActivity {

    @InjectView(R.id.image_dribble)
    ImageView dribbbleImage;

    @InjectView(R.id.text_tittle_dribble)
    TextView dribbbleTittle;

    @InjectView(R.id.text_views_count)
    TextView textCount;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.image_avatar)
    ImageView imageAuthorAvatar;

    @InjectView(R.id.text_author_name)
    TextView textAuthorName;

    @InjectView(R.id.text_description)
    TextView textDescription;

    Shot shot;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_shot);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shot = (Shot) getBundle().getSerializable(BundleKeys.SHOT);
        showShot();
        configureToolbar(shot);
        dribbbleImage.setOnClickListener(v -> showZoomImage());
    }

    private void showZoomImage() {
        final Intent intent = new Intent(this, ShotViewActivity.class);
        intent.putExtra(BundleKeys.SHOT, shot);
        startActivity(intent);
    }

    private void showShot() {
        DribbblePicasso.with(this, shot.getImageUrl()).into(dribbbleImage, callback);
        dribbbleTittle.setText(shot.getTitle());
        textCount.setText(String.valueOf(shot.getViewsCount()));
        DribbblePicasso.with(this, shot.getPlayer().getAvatarUrl()).into(imageAuthorAvatar);
        textAuthorName.setText(shot.getPlayer().getName());

        if (shot.getDescription() != null) {
            textDescription.setText(Html.fromHtml(shot.getDescription()));
            textDescription.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void configureToolbar(Shot shot) {
        setSupportActionBar(toolbar);
        setTitle(shot.getTitle());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void injectMembers() {
        dribbleComponent().inject(this);
    }

    private final Callback callback = new Callback() {
        @Override
        public void onSuccess() {
            Palette.from(((BitmapDrawable) dribbbleImage.getDrawable()).getBitmap()).generate(palette -> {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();

                if (vibrantSwatch != null) {
                    toolbar.setBackgroundColor(vibrantSwatch.getRgb());
                    toolbar.setTitleTextColor(R.color.background_screen);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ColorUtil.getDarkerColor(vibrantSwatch.getRgb()));
                    }
                }
            });
        }

        @Override
        public void onError() {

        }
    };
}
