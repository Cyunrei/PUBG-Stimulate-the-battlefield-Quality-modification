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
//	private static final String TAG= null;

	private void createFile()
	{  
        String filePath = fileDirPath + "/" + fileName;
        try
		{  
            File dir = new File(fileDirPath);// 目录路径  
            if (!dir.exists())
			{// 如果不存在，则创建路径名  
				//Log.d(TAG, "要存储的目录不存在");  
                if (dir.mkdirs())
				{// 创建该路径名，返回true则表示创建成功  
					//Log.d(TAG, "已经创建文件存储目录");  
                }
				else
				{  
					//Log.d(TAG, "创建目录失败");  
                }  
            }  
            // 目录存在，则将apk中raw中的需要的文档复制到该目录下  
            File file = new File(filePath);  
            if (!file.exists())
			{// 文件不存在  
				//Log.d(TAG, "要打开的文件不存在");  
				AssetManager am = null;  

				am = getAssets();  

				InputStream ins = am.open("UserCustom.ini");  

				//Log.d(TAG, "开始读入");  
                FileOutputStream fos = new FileOutputStream(file);  
				//Log.d(TAG, "开始写出");  
                byte[] buffer = new byte[8192];  
                int count = 0;// 循环写出  
                while ((count = ins.read(buffer)) > 0)
				{  
                    fos.write(buffer, 0, count);  
                }  
				//Log.d(TAG, "已经创建该文件");  

                fos.close();// 关闭流  
                ins.close();  
            }  
        }
		catch (Exception e)
		{  
            e.printStackTrace();  
        }  
    }  



    @Override
    protected void onCreate(Bundle savedInstanceState)
	{	

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
			
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			{

				//添加变色标志
				this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
				//设置状态栏文字颜色及图标为浅色
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
				//设置虚拟按键颜色为白色
				getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
			}
			createFile();

			Toast.makeText(MainActivity.this, "所有设置重启此应用和游戏后生效", Toast.LENGTH_SHORT).show();


			fluencyManager = getPreferenceManager();
			fluencyList = (ListPreference) fluencyManager.findPreference("fluency");
			String fluency = fluencyList.getValue();
			if (fluency.equals("0"))
			{}
			else if (fluency.equals("1"))
			{	
				Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "当前流畅度：流畅");
			}
			else if (fluency.equals("2"))
			{

				Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "当前流畅度：均衡");
			}
			else if (fluency.equals("3"))
			{	
				Runtime.getRuntime().exec("sed -i 3c\\+CVars=r.UserQualitySetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "当前流畅度：高清");
			}

			special_effectsManager = getPreferenceManager();
			special_effectsList = (ListPreference) special_effectsManager.findPreference("special_effects");
			String special_effects = special_effectsList.getValue();
			if (special_effects.equals("0"))
			{}
			else if (special_effects.equals("1"))
			{	
				Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏特效:无");
			}
			else if (special_effects.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏特效：低");
			}
			else if (special_effects.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏特效：中");
			}
			else if (special_effects.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 13c\\+CVars=r.BloomQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏特效：高");
			}

			frameManager = getPreferenceManager();
			frameList = (ListPreference) frameManager.findPreference("frame");
			String frame = frameList.getValue();
			if (frame.equals("0"))
			{}
			else if (frame.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏帧率:低");
			}
			else if (frame.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏帧率：中");
			}
			else if (frame.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 2c\\+CVars=r.PUBGQualityLevel=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "游戏帧率：高");
			}
			material_levelManager = getPreferenceManager();
			material_levelList = (ListPreference) material_levelManager.findPreference("material_level");
			String material_level = material_levelList.getValue();
			if (material_level.equals("0"))
			{}
			else if (material_level.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "材质水平:低画质");
			}
			else if (material_level.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "材质水平:中等画质");
			}
			else if (material_level.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=1.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "材质水平:高清画质");
			}
			else if (material_level.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 9c\\+CVars=r.MaterialQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "材质水平:超高清画质");
			}

			image_quality_styleManager = getPreferenceManager();
			image_quality_styleList = (ListPreference) image_quality_styleManager.findPreference("image_quality_style");
			String image_quality_style = image_quality_styleList.getValue();

			if (image_quality_style.equals("0"))
			{}
			else if (image_quality_style.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "画质风格:无风格");
			}
			else if (image_quality_style.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "画质风格:经典");
			}
			else if (image_quality_style.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "画质风格:鲜艳");
			}
			else if (image_quality_style.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 8c\\+CVars=r.UserHDRSetting=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "画质风格:写实");
			}

			ui_resolutionManager = getPreferenceManager();
			ui_resolutionList = (ListPreference) ui_resolutionManager.findPreference("ui_resolution");
			String ui_resolution = ui_resolutionList.getValue();
			if (ui_resolution.equals("0"))
			{}
			else if (ui_resolution.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "界面分辨率:低");
			}
			else if (ui_resolution.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "界面分辨率:中");
			}
			else if (ui_resolution.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 6c\\+CVars=r.MobileContentScaleFactor=1.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "界面分辨率:高");
			}

			shadow_resolutionManager = getPreferenceManager();
			shadow_resolutionList = (ListPreference) shadow_resolutionManager.findPreference("shadow_resolution");
			String shadow_resolution = shadow_resolutionList.getValue();
			if (shadow_resolution.equals("0"))
			{}
			else if (shadow_resolution.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影分辨率:0");
			}
			else if (shadow_resolution.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=128 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影分辨率:128");
			}
			else if (shadow_resolution.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=512 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影分辨率:512");
			}
			else if (shadow_resolution.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=1024 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影分辨率:1024");
			}
			else if (shadow_resolution.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 10c\\+CVars=r.Shadow.MaxCSMResolution=2048 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影分辨率:2048");
			}

			shadow_visible_distanceManager = getPreferenceManager();
			shadow_visible_distanceList = (ListPreference) shadow_visible_distanceManager.findPreference("shadow_visible_distance");
			String shadow_visible_distance = shadow_visible_distanceList.getValue();
			if (shadow_visible_distance.equals("0"))
			{}
			else if (shadow_visible_distance.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.3");
			}
			else if (shadow_visible_distance.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.4");
			}
			else if (shadow_visible_distance.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.5");
			}
			else if (shadow_visible_distance.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.6");
			}
			else if (shadow_visible_distance.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.7");
			}
			else if (shadow_visible_distance.equals("6"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.8");
			}
			else if (shadow_visible_distance.equals("7"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=0.9 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:0.9");
			}
			else if (shadow_visible_distance.equals("8"))
			{
				Runtime.getRuntime().exec("sed -i 12c\\+CVars=r.Shadow.DistanceScale=1.0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影可视距离:1.0");
			}

			shadow_qualityManager = getPreferenceManager();
			shadow_qualityList = (ListPreference) shadow_qualityManager.findPreference("shadow_quality");
			String shadow_quality = shadow_qualityList.getValue();
			if (shadow_quality.equals("0"))
			{}
			else if (shadow_quality.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影质量:无");
			}
			else if (shadow_quality.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影质量:低");
			}
			else if (shadow_quality.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影质量:中");
			}
			else if (shadow_quality.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 5c\\+CVars=r.ShadowQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "阴影质量:高");
			}

			heterosexual_filtrationManager = getPreferenceManager();
			heterosexual_filtrationList = (ListPreference) heterosexual_filtrationManager.findPreference("heterosexual_filtration");
			String heterosexual_filtration = heterosexual_filtrationList.getValue();
			if (heterosexual_filtration.equals("0"))
			{}
			else if (heterosexual_filtration.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:1");
			}
			else if (heterosexual_filtration.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:2");
			}
			else if (heterosexual_filtration.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:3");
			}
			else if (heterosexual_filtration.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:4");
			}
			else if (heterosexual_filtration.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:5");
			}
			else if (heterosexual_filtration.equals("6"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:6");
			}
			else if (heterosexual_filtration.equals("7"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:7");
			}
			else if (heterosexual_filtration.equals("8"))
			{
				Runtime.getRuntime().exec("sed -i 21c\\+CVars=r.MaxAnisotropy=8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Log.d(TAG,  "各项异性过滤:8");
			}
		}
		catch (IOException e)
		{}

    }

}
