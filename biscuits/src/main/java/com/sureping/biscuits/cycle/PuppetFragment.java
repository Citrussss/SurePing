package com.sureping.biscuits.cycle;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;

/**
 * @author sureping
 * @create 19-4-17.
 */
public class PuppetFragment extends Fragment {
    private static final int PERMISSION_CODE = 1000;
    private Consumer consumer;

//    onRequestPermissionsResult
//    requestPermissions
    public void requestPermissions(String... permissions){
        requestPermissions(permissions,PERMISSION_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISSION_CODE){

        }
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    private class Result{

    }
}
