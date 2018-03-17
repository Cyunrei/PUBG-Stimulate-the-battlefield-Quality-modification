package settings.image_quality.pubgmhd;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.ListPreference;
import android.widget.Toast;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import android.content.res.AssetManager;
import android.os.Build;
import android.graphics.Color;
import android.view.View;
import android.util.Log;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends PreferenceActivity
{
	PreferenceManager fluencyManager;
	ListPreference fluencyList;

	PreferenceManager special_effectsManager;
	ListPreference special_effectsList;

	PreferenceManager frameManager;
	ListPreference frameList;

	PreferenceManager material_levelManager;
	ListPreference material_levelList;

	PreferenceManager image_quality_styleManager;
	ListPreference image_quality_styleList;

	PreferenceManager ui_resolutionManager;
	ListPreference ui_resolutionList;

	PreferenceManager shadow_resolutionManager;
	ListPreference shadow_resolutionList;

	PreferenceManager shadow_visible_distanceManager;
	ListPreference shadow_visible_distanceList;

	PreferenceManager shadow_qualityManager;
	ListPreference shadow_qualityList;

	PreferenceManager heterosexual_filtrationManager;
	ListPreference heterosexual_filtrationList;



	private String fileDirPath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android";
    private String fileName = "UserCustom.ini";
//	private static final String TAG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{	


		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);


		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{

			this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			//getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
			getWindow().setStatusBarColor(Color.parseColor("#E0E0E0"));
			//getWindow().setNavigationBarColor(Color.WHITE);

		}


		SharedPreferences updateReader = getSharedPreferences("dialog", MODE_PRIVATE);

		String Updatealue = updateReader.getString("update", "");

		if (Updatealue.equals("1"))
		{
			//不提示对话框
		}
		else
		{
			updateDialog();
		}


		SharedPreferences tipReader= getSharedPreferences("dialog", MODE_PRIVATE);

		String tipValue = tipReader.getString("tip", "");

		if (tipValue.equals("1"))
		{
			//不提示对话框
		}
		else
		{
			tipDialog();
		}

		try
		{

			java.lang.Process p = Runtime.getRuntime().exec("rm -R /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
			try
			{
				p.waitFor();
			}
			catch (InterruptedException e)
			{}
			p.destroy();

			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.main_activity);

			createFile();

			//Toast.makeText(MainActivity.this, "所有设置重启此应用和游戏后生效", Toast.LENGTH_SHORT).show();

			fluencyManager = getPreferenceManager();
			fluencyList = (ListPreference) fluencyManager.findPreference("fluency");
			String fluency = fluencyList.getValue();
			if (fluency.equals("0"))
			{}
			else if (fluency.equals("1"))
			{	
				//Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 4c\\+CVars=0B572C0A1C0B280C1815100D002A1C0D0D10171E4449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "当前流畅度：流畅");
			}
			else if (fluency.equals("2"))
			{

				//Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 4c\\+CVars=0B572C0A1C0B280C1815100D002A1C0D0D10171E4448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "当前流畅度：均衡");
			}
			else if (fluency.equals("3"))
			{	
				//Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 4c\\+CVars=0B572C0A1C0B280C1815100D002A1C0D0D10171E444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "当前流畅度：高清");
			}

			special_effectsManager = getPreferenceManager();
			special_effectsList = (ListPreference) special_effectsManager.findPreference("special_effects");
			String special_effects = special_effectsList.getValue();
			if (special_effects.equals("0"))
			{}
			else if (special_effects.equals("1"))
			{	
				//Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 20c\\+CVars=0B573B15161614280C1815100D004449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏特效:无");
			}
			else if (special_effects.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 20c\\+CVars=0B573B15161614280C1815100D004448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏特效：低");
			}
			else if (special_effects.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 20c\\+CVars=0B573B15161614280C1815100D00444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏特效：中");
			}
			else if (special_effects.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 20c\\+CVars=0B573B15161614280C1815100D00444A /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏特效：高");
			}

			frameManager = getPreferenceManager();
			frameList = (ListPreference) frameManager.findPreference("frame");
			String frame = frameList.getValue();
			if (frame.equals("0"))
			{}
			else if (frame.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A35160E444B49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444B49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444B49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 11c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A313D2B444B49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏帧率:20");
			}
			else if (frame.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A35160E444A49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444A49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444A49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 11c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A313D2B444A49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏帧率：30");
			}
			else if (frame.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A35160E444D49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444D49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444D49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 11c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A313D2B444D49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏帧率：40");
			}
			else if (frame.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A35160E444C49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444C49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444C49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 11c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A313D2B444C49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏帧率：50");
			}
			else if (frame.equals("5"))
			{
				//Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A35160E444F49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444F49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A34101D444F49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 11c\\+CVars=0B57292C3B3E3D1C0F101A1C3F292A313D2B444F49 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "游戏帧率：60");
			}
			material_levelManager = getPreferenceManager();
			material_levelList = (ListPreference) material_levelManager.findPreference("material_level");
			String material_level = material_levelList.getValue();
			if (material_level.equals("0"))
			{}
			else if (material_level.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 25c\\+CVars=0B5734180D1C0B101815280C1815100D00351C0F1C154449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "材质水平:低画质");
			}
			else if (material_level.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 25c\\+CVars=0B5734180D1C0B101815280C1815100D00351C0F1C154448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "材质水平:中等画质");
			}
			else if (material_level.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=1.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 25c\\+CVars=0B5734180D1C0B101815280C1815100D00351C0F1C154448574C /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "材质水平:高清画质");
			}
			else if (material_level.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 25c\\+CVars=0B5734180D1C0B101815280C1815100D00351C0F1C15444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "材质水平:超高清画质");
			}

			image_quality_styleManager = getPreferenceManager();
			image_quality_styleList = (ListPreference) image_quality_styleManager.findPreference("image_quality_style");
			String image_quality_style = image_quality_styleList.getValue();

			if (image_quality_style.equals("0"))
			{}
			else if (image_quality_style.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 16c\\+CVars=0B572C0A1C0B313D2B2A1C0D0D10171E4449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "画质风格:无风格");
			}
			else if (image_quality_style.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 16c\\+CVars=0B572C0A1C0B313D2B2A1C0D0D10171E4448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "画质风格:经典");
			}
			else if (image_quality_style.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 16c\\+CVars=0B572C0A1C0B313D2B2A1C0D0D10171E444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "画质风格:鲜艳");
			}
			else if (image_quality_style.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 16c\\+CVars=0B572C0A1C0B313D2B2A1C0D0D10171E444A /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "画质风格:写实");
			}

			ui_resolutionManager = getPreferenceManager();
			ui_resolutionList = (ListPreference) ui_resolutionManager.findPreference("ui_resolution");
			String ui_resolution = ui_resolutionList.getValue();
			if (ui_resolution.equals("0"))
			{}
			else if (ui_resolution.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 13\\+CVars=0B5734161B10151C3A16170D1C170D2A1A18151C3F181A0D160B44485749 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "界面分辨率:低");
			}
			else if (ui_resolution.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 13\\+CVars=0B5734161B10151C3A16170D1C170D2A1A18151C3F181A0D160B4448574B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "界面分辨率:中");
			}
			else if (ui_resolution.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 13\\+CVars=0B5734161B10151C3A16170D1C170D2A1A18151C3F181A0D160B4448574C /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "界面分辨率:高");
			}

			shadow_resolutionManager = getPreferenceManager();
			shadow_resolutionList = (ListPreference) shadow_resolutionManager.findPreference("shadow_resolution");
			String shadow_resolution = shadow_resolutionList.getValue();
			if (shadow_resolution.equals("0"))
			{}
			else if (shadow_resolution.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 26c\\+CVars=0B572A11181D160E573418013A2A342B1C0A16150C0D1016174449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影分辨率:0");
			}
			else if (shadow_resolution.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=128 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 26c\\+CVars=0B572A11181D160E573418013A2A342B1C0A16150C0D10161744484B41 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影分辨率:128");
			}
			else if (shadow_resolution.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=512 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 26c\\+CVars=0B572A11181D160E573418013A2A342B1C0A16150C0D101617444C484B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影分辨率:512");
			}
			else if (shadow_resolution.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=1024 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 26c\\+CVars=0B572A11181D160E573418013A2A342B1C0A16150C0D1016174448494B4D /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影分辨率:1024");
			}
			else if (shadow_resolution.equals("5"))
			{
				//Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=2048 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 26c\\+CVars=0B572A11181D160E573418013A2A342B1C0A16150C0D101617444B494D41 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影分辨率:2048");
			}

			shadow_visible_distanceManager = getPreferenceManager();
			shadow_visible_distanceList = (ListPreference) shadow_visible_distanceManager.findPreference("shadow_visible_distance");
			String shadow_visible_distance = shadow_visible_distanceList.getValue();
			if (shadow_visible_distance.equals("0"))
			{}
			else if (shadow_visible_distance.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C4449574A /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.3");
			}
			else if (shadow_visible_distance.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C4449574D /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.4");
			}
			else if (shadow_visible_distance.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C4449574C /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.5");
			}
			else if (shadow_visible_distance.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C4449574F /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.6");
			}
			else if (shadow_visible_distance.equals("5"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C4449574E /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.7");
			}
			else if (shadow_visible_distance.equals("6"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C44495741 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.8");
			}
			else if (shadow_visible_distance.equals("7"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.9 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C44495740 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:0.9");
			}
			else if (shadow_visible_distance.equals("8"))
			{
				//Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=1.0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 28c\\+CVars=0B572A11181D160E573D100A0D18171A1C2A1A18151C44485749 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影可视距离:1.0");
			}

			shadow_qualityManager = getPreferenceManager();
			shadow_qualityList = (ListPreference) shadow_qualityManager.findPreference("shadow_quality");
			String shadow_quality = shadow_qualityList.getValue();
			if (shadow_quality.equals("0"))
			{}
			else if (shadow_quality.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=0B572A11181D160E280C1815100D004449 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影质量:无");
			}
			else if (shadow_quality.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=0B572A11181D160E280C1815100D004448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影质量:低");
			}
			else if (shadow_quality.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=0B572A11181D160E280C1815100D00444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影质量:中");
			}
			else if (shadow_quality.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=0B572A11181D160E280C1815100D00444A /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "阴影质量:高");
			}

			heterosexual_filtrationManager = getPreferenceManager();
			heterosexual_filtrationList = (ListPreference) heterosexual_filtrationManager.findPreference("heterosexual_filtration");
			String heterosexual_filtration = heterosexual_filtrationList.getValue();
			if (heterosexual_filtration.equals("0"))
			{}
			else if (heterosexual_filtration.equals("1"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B1609004448 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:1");
			}
			else if (heterosexual_filtration.equals("2"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444B /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:2");
			}
			else if (heterosexual_filtration.equals("3"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444A /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:3");
			}
			else if (heterosexual_filtration.equals("4"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444D /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:4");
			}
			else if (heterosexual_filtration.equals("5"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444C /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:5");
			}
			else if (heterosexual_filtration.equals("6"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444F /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:6");
			}
			else if (heterosexual_filtration.equals("7"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B160900444E /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:7");
			}
			else if (heterosexual_filtration.equals("8"))
			{
				//Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				Runtime.getRuntime().exec("sed -i 35c\\+CVars=0B573418013817100A160D0B1609004441 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				//Log.d(TAG,  "各项异性过滤:8");
			}
		}
		catch (IOException e)
		{}

    }

	private void createFile()
	{  
        String filePath = fileDirPath + "/" + fileName;
        try
		{  
            File dir = new File(fileDirPath);
            if (!dir.exists())
			{
				//Log.d(TAG, "要存储的目录不存在");  
                if (dir.mkdirs())
				{
					//Log.d(TAG, "已经创建文件存储目录");  
                }
				else
				{  
					//Log.d(TAG, "创建目录失败");  
                }  
            }  

            File file = new File(filePath);  
            if (!file.exists())
			{
				//Log.d(TAG, "要打开的文件不存在");  
				AssetManager am = null;  

				am = getAssets();  

				InputStream ins = am.open("UserCustom.ini");  

                FileOutputStream fos = new FileOutputStream(file);  

                byte[] buffer = new byte[8192];  
                int count = 0;
                while ((count = ins.read(buffer)) > 0)
				{  
                    fos.write(buffer, 0, count);  
                }  
				//Log.d(TAG, "已经创建该文件");  

                fos.close();
                ins.close();  
            }  
        }
		catch (Exception e)
		{  
            e.printStackTrace();  
        }  
    }  

	private void updateDialog()
	{

		final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);

		normalDialog.setTitle("更新日志");
		normalDialog.setMessage("支持Android P(03-12)\n优化部分代码(03-12)\n适配了Android M以上的权限问题(03-13)\n全新的Android O主题(03-15)\n支持对游戏加密配置的修改(03-17)");
		normalDialog.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{

				}
			});

		SharedPreferences.Editor editor = getSharedPreferences("dialog", MODE_PRIVATE).edit();
		editor.putString("update", "1");
		editor.commit();

		normalDialog.show();
	}

	private void tipDialog()
	{

		final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);

		normalDialog.setTitle("提示");
		normalDialog.setMessage("使用说明\n•程序的正常运行需要读写内部存储权限\n•请注意默认配置在你的手机上是否能流畅运行\n•已解决游戏配置加密问题(些许会有些BUG)\n•使用自定义配置后需要再重启本程序一次配置文件才能生效\n•配置过高或配置不当会导致游戏自动恢复默认");
		normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{

				}
			});
		normalDialog.setNegativeButton("下次不再提示", 
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					SharedPreferences.Editor editor = getSharedPreferences("dialog", MODE_PRIVATE).edit();
					editor.putString("tip", "1");
					editor.commit();
				}
			});

		normalDialog.show();
	}

}
