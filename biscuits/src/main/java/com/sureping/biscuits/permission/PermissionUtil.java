package com.sureping.biscuits.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import com.sureping.biscuits.cycle.PuppetFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static android.content.ContentValues.TAG;

/**
 * @author sureping
 * @create 19-4-17.
 */
public class PermissionUtil {


    /**
     * 检查权限
     *
     * @return
     */
    private static boolean hadPermission(Context context, String permission) {
        return !(ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED);
    }

    /**
     * 检查复数权限
     *
     * @return
     */
    private static boolean hadPermissions(Context context, String... permissions) {
        for (String permission : permissions) {
            if (!hadPermission(context, permission)) return false;
        }
        return true;
    }

    public PermissionControl Build(FragmentActivity activity) {
        return new PermissionControl(activity);
//        manager.executePendingTransactions();
    }

    /*private static boolean requestPermission(Activity activity, String... permissions){
//        activity.requestPermissions(permissions,0);
        ActivityCompat.requestPermissions(activity,permissions,0);
    }*/
    private static void requestPermission(PuppetFragment fragment, String... permissions) {
        fragment.requestPermissions(permissions, 0);
//        ActivityCompat.requestPermissions(activity,permissions,0);
    }

    private class PermissionControl {
        public static final String TAG = "PermissionUtil";

        private PuppetFragment puppetFragment;
        private String[] permissions;
        public PermissionControl(FragmentActivity activity) {
            FragmentManager manager = activity.getSupportFragmentManager();
            puppetFragment = new PuppetFragment();
            manager.beginTransaction()
                    .add(puppetFragment, TAG)
                    .commitAllowingStateLoss();
        }
        public <T>void requestPermissions(Consumer<T> consumer,String... permissions){
            this.permissions =permissions;
            puppetFragment.setConsumer(consumer);
            puppetFragment.requestPermissions(permissions);
        }
//        public
    }
}
