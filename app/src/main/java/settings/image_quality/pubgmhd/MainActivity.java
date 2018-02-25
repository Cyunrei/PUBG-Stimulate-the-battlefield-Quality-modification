package settings.image_quality.pubgmhd;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.ListPreference;
import android.widget.Toast;
import java.io.IOException;

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
	
	PreferenceManager shadow_resolutionManager;
	ListPreference shadow_resolutionList;
	
	PreferenceManager shadow_visible_distanceManager;
	ListPreference shadow_visible_distanceList;
	
	PreferenceManager shadow_qualityManager;
	ListPreference shadow_qualityList;
	
	PreferenceManager heterosexual_filtrationManager;
	ListPreference heterosexual_filtrationList;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main_activity);
		
		Toast.makeText(MainActivity.this, "所有设置重启此应用和游戏后生效", Toast.LENGTH_SHORT).show();
		
		try
		{
			fluencyManager = getPreferenceManager();
			fluencyList = (ListPreference) fluencyManager.findPreference("fluency");
			String fluency = fluencyList.getValue();
			if (fluency.equals("0"))
			{}
			else if (fluency.equals("1"))
			{	
				Runtime.getRuntime().exec("sed -i 30c\\+CVars=r.UserQualitySetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "当前流畅度：流畅", Toast.LENGTH_SHORT).show();
			}
			else if (fluency.equals("2"))
			{

				Runtime.getRuntime().exec("sed -i 30c\\+CVars=r.UserQualitySetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "当前流畅度：均衡", Toast.LENGTH_SHORT).show();
			}
			else if (fluency.equals("3"))
			{	
				Runtime.getRuntime().exec("sed -i 30c\\+CVars=r.UserQualitySetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Toast.makeText(MainActivity.this, "当前流畅度：高清", Toast.LENGTH_SHORT).show();
			}

			special_effectsManager = getPreferenceManager();
			special_effectsList = (ListPreference) special_effectsManager.findPreference("special_effects");
			String special_effects = special_effectsList.getValue();
			if (special_effects.equals("0"))
			{}
			else if (special_effects.equals("1"))
			{	
				Runtime.getRuntime().exec("sed -i 40c\\+CVars=r.BloomQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "游戏特效:无", Toast.LENGTH_SHORT).show();
			}
			else if (special_effects.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 40c\\+CVars=r.BloomQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "游戏特效：低", Toast.LENGTH_SHORT).show();
			}
			else if (special_effects.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 40c\\+CVars=r.BloomQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "游戏特效：中", Toast.LENGTH_SHORT).show();
			}
			else if (special_effects.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 40c\\+CVars=r.BloomQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "游戏特效：高", Toast.LENGTH_SHORT).show();
			}

			frameManager = getPreferenceManager();
			frameList = (ListPreference) frameManager.findPreference("frame");
			String frame = frameList.getValue();
			if (frame.equals("0"))
			{}
			else if (frame.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 29c\\+CVars=r.PUBGQualityLevel=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Toast.makeText(MainActivity.this, "游戏帧率:低", Toast.LENGTH_SHORT).show();
			}
			else if (frame.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 29c\\+CVars=r.PUBGQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");

				//Toast.makeText(MainActivity.this, "游戏帧率：高", Toast.LENGTH_SHORT).show();
			}

			material_levelManager = getPreferenceManager();
			material_levelList = (ListPreference) material_levelManager.findPreference("material_level");
			String material_level = material_levelList.getValue();
			if (material_level.equals("0"))
			{}
			else if (material_level.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 36c\\+CVars=r.MaterialQualityLevel=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "材质水平:低画质", Toast.LENGTH_SHORT).show();
			}
			else if (material_level.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 36c\\+CVars=r.MaterialQualityLevel=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "材质水平:中等画质", Toast.LENGTH_SHORT).show();
			}
			else if (material_level.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 36c\\+CVars=r.MaterialQualityLevel=1.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "材质水平:高清画质", Toast.LENGTH_SHORT).show();
			}
			else if (material_level.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 36c\\+CVars=r.MaterialQualityLevel=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "材质水平:超高清画质", Toast.LENGTH_SHORT).show();
			}

			image_quality_styleManager = getPreferenceManager();
			image_quality_styleList = (ListPreference) image_quality_styleManager.findPreference("image_quality_style");
			String image_quality_style = image_quality_styleList.getValue();
			if (image_quality_style.equals("0"))
			{}
			else if (image_quality_style.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 34c\\+CVars=r.UserHDRSetting=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "画质风格:无风格", Toast.LENGTH_SHORT).show();
			}
			else if (image_quality_style.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 34c\\+CVars=r.UserHDRSetting=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "画质风格:经典", Toast.LENGTH_SHORT).show();
			}
			else if (image_quality_style.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 34c\\+CVars=r.UserHDRSetting=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "画质风格:鲜艳", Toast.LENGTH_SHORT).show();
			}
			else if (image_quality_style.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 34c\\+CVars=r.UserHDRSetting=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "画质风格:写实", Toast.LENGTH_SHORT).show();
			}

			shadow_resolutionManager = getPreferenceManager();
			shadow_resolutionList = (ListPreference) shadow_resolutionManager.findPreference("shadow_resolution");
			String shadow_resolution = shadow_resolutionList.getValue();
			if (shadow_resolution.equals("0"))
			{}
			else if (shadow_resolution.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 37c\\+CVars=r.Shadow.MaxCSMResolution=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影分辨率:0", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_resolution.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 37c\\+CVars=r.Shadow.MaxCSMResolution=128 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影分辨率:128", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_resolution.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 37c\\+CVars=r.Shadow.MaxCSMResolution=512 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影分辨率:512", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_resolution.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 37c\\+CVars=r.Shadow.MaxCSMResolution=1024 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影分辨率:1024", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_resolution.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 37c\\+CVars=r.Shadow.MaxCSMResolution=2048 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影分辨率:2048", Toast.LENGTH_SHORT).show();
			}

			shadow_visible_distanceManager = getPreferenceManager();
			shadow_visible_distanceList = (ListPreference) shadow_visible_distanceManager.findPreference("shadow_visible_distance");
			String shadow_visible_distance = shadow_visible_distanceList.getValue();
			if (shadow_visible_distance.equals("0"))
			{}
			else if (shadow_visible_distance.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.3", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.4", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.5", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.6", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.7", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("6"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.8", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("7"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=0.9 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:0.9", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_visible_distance.equals("8"))
			{
				Runtime.getRuntime().exec("sed -i 39c\\+CVars=r.Shadow.DistanceScale=1.0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影可视距离:1.0", Toast.LENGTH_SHORT).show();
			}

			shadow_qualityManager = getPreferenceManager();
			shadow_qualityList = (ListPreference) shadow_qualityManager.findPreference("shadow_quality");
			String shadow_quality = shadow_qualityList.getValue();
			if (shadow_quality.equals("0"))
			{}
			else if (shadow_quality.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 32c\\+CVars=r.ShadowQuality=0 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影质量:无", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_quality.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 32c\\+CVars=r.ShadowQuality=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影质量:低", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_quality.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 32c\\+CVars=r.ShadowQuality=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影质量:中", Toast.LENGTH_SHORT).show();
			}
			else if (shadow_quality.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 32c\\+CVars=r.ShadowQuality=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "阴影质量:高", Toast.LENGTH_SHORT).show();
			}

			heterosexual_filtrationManager = getPreferenceManager();
			heterosexual_filtrationList = (ListPreference) heterosexual_filtrationManager.findPreference("heterosexual_filtration");
			String heterosexual_filtration = heterosexual_filtrationList.getValue();
			if (heterosexual_filtration.equals("0"))
			{}
			else if (heterosexual_filtration.equals("1"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=1 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:1", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("2"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=2 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:2", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("3"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=3 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:3", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("4"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=4 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:4", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("5"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=5 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:5", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("6"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=6 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:6", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("7"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=7 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:7", Toast.LENGTH_SHORT).show();
			}
			else if (heterosexual_filtration.equals("8"))
			{
				Runtime.getRuntime().exec("sed -i 48c\\+CVars=r.MaxAnisotropy=8 /sdcard/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini");
				
				//Toast.makeText(MainActivity.this, "各项异性过滤:8", Toast.LENGTH_SHORT).show();
			}
		}
		catch (IOException e)
		{}

    }

}
