package com.celsius.customstocks.custombehaviour;

import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class BottomNavigationViewBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

    private int height;

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, BottomNavigationView child, int layoutDirection) {
        height = child.getHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       BottomNavigationView child, @NonNull
                                               View directTargetChild, @NonNull View target,
                                       int axes, int type)
    {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child,
                               @NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed,
                               @ViewCompat.NestedScrollType int type)
    {
        if (dyConsumed > 0) {
            slideDown(child);
        } else if (dyConsumed < 0) {
            slideUp(child);
        }
    }

    private void slideUp(BottomNavigationView child) {
        child.clearAnimation();
        child.animate().translationY(0).setDuration(400);
    }

    private void slideDown(BottomNavigationView child) {
        child.clearAnimation();
        child.animate().translationY(height).setDuration(400);
    }
}
