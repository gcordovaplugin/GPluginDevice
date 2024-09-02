package cn.yingzhichu.cordova.gdevice;

import android.content.pm.PackageInfo;
import android.os.Build;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.TimeZone;

/**
 * This class echoes a string called from JavaScript.
 */
public class GDevice extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            PackageInfo packageInfo = cordova.getContext().getPackageManager().getPackageInfo(cordova.getContext().getPackageName(),0);
            JSONObject ret = new JSONObject();
            TimeZone timeZone = TimeZone.getDefault();
            Locale locale = Locale.getDefault();
            
            ret.put("platform","android");

            ret.put("android_manufacturer", Build.MANUFACTURER);
            ret.put("android_device", Build.DEVICE);
            ret.put("android_fingerorint", Build.FINGERPRINT);
            ret.put("android_board", Build.BOARD);
            ret.put("android_model", Build.MODEL);
            ret.put("android_serial", Build.SERIAL);
            ret.put("android_product", Build.PRODUCT);
            ret.put("android_hardware", Build.HARDWARE);
            ret.put("android_id", Build.ID);



            ret.put("ver_name",packageInfo.versionName);
            ret.put("ver_code",packageInfo.versionCode);

            ret.put("timezone_name",timeZone.getDisplayName());
            ret.put("timezone_id",timeZone.getID());
            ret.put("timezone_rawoffset",timeZone.getRawOffset());
            ret.put("dstsavings",timeZone.getDSTSavings());

            ret.put("local_country",locale.getCountry());
            ret.put("local_display_country",locale.getDisplayCountry());
            ret.put("local_display_name",locale.getDisplayName());
            ret.put("local_language",locale.getLanguage());
            ret.put("local_display_language",locale.getDisplayLanguage());
            ret.put("local_variant",locale.getVariant());
            ret.put("local_display_variant",locale.getDisplayVariant());
            callbackContext.success(ret);
        }catch (Exception e){}

        return true;
    }

}
