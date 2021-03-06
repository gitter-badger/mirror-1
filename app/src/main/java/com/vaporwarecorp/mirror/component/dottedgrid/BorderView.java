/*
 * Copyright 2016 Johann Reyes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vaporwarecorp.mirror.component.dottedgrid;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import static com.vaporwarecorp.mirror.util.DisplayMetricsUtil.convertDpToPixel;

class BorderView extends FrameLayout {
// ------------------------------ FIELDS ------------------------------

    @ColorInt
    private int mColorRed;
    @ColorInt
    private int mColorTransparent;
    @ColorInt
    private int mColorWhite;
    private boolean mLeftAligned;
    private boolean mRightAligned;

// --------------------------- CONSTRUCTORS ---------------------------

    public BorderView(Context context) {
        this(context, null);
    }

    public BorderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeLayout(context);
    }

// -------------------------- OTHER METHODS --------------------------

    public void hideBorder() {
        setBackgroundColor(mColorTransparent);
    }

    public boolean isCenterAligned() {
        return !mLeftAligned && !mRightAligned;
    }

    public boolean isLeftAligned() {
        return mLeftAligned;
    }

    public boolean isRightAligned() {
        return mRightAligned;
    }

    public void setCenterAligned() {
        mLeftAligned = false;
        mRightAligned = false;
    }

    public void setLeftAligned() {
        mLeftAligned = true;
        mRightAligned = false;
    }

    public void setRightAligned() {
        mLeftAligned = false;
        mRightAligned = true;
    }

    public void showBorder() {
        setBackgroundColor(mColorWhite);
    }

    public void showBorderWarning() {
        setBackgroundColor(mColorRed);
    }

    private void initializeLayout(final Context context) {
        mColorTransparent = ContextCompat.getColor(context, android.R.color.transparent);
        mColorWhite = ContextCompat.getColor(context, android.R.color.white);
        mColorRed = ContextCompat.getColor(context, android.R.color.holo_red_dark);

        final int borderPadding = Math.round(convertDpToPixel(4, context));
        setPadding(borderPadding, borderPadding, borderPadding, borderPadding);
    }
}
