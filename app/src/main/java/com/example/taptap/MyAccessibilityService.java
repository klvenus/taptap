
package com.example.taptap;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // No event handling required
    }

    @Override
    public void onInterrupt() {
        // No interrupt handling required
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        performTap(500, 500); // Coordinates for the tap action
    }

    private void performTap(float x, float y) {
        Path path = new Path();
        path.moveTo(x, y);
        GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(path, 0, 100);
        GestureDescription gestureDescription = new GestureDescription.Builder().addStroke(strokeDescription).build();
        dispatchGesture(gestureDescription, null, null);
    }
}
