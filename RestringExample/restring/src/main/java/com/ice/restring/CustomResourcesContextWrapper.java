package com.ice.restring;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.Log;

/**
 * A context wrapper which provide another Resources instead of the original one.
 */
class CustomResourcesContextWrapper extends ContextWrapper {

    private Resources resources;

    public CustomResourcesContextWrapper(Context base, Resources resources) {

        super(base);
        this.resources = resources;
        Log.v("Called","CustomResourcesContextWrapper.constructor()");

    }

    @Override
    public Resources getResources() {
        return resources;
    }
}
