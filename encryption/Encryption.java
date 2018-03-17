import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Encryption
{

	char plaintext[]; 
	String ciphertext[]; 
	StringBuffer plainStr = new StringBuffer("");	
	StringBuffer cipherStr = new StringBuffer("");	
	
	EncryptionContrastList C = new EncryptionContrastList();
	Map<Character, String> maplist = C.maplist;

	public static void main(String[] args)
	{
		System.out.println("绝地求生刺激战场加密程序(1.0.1.180317_Java)\nCopyright ©2018 Cyunrei All rights reserved.\n===============================================================================");
		
		for (long i=1;i < Long.MAX_VALUE ;i++)
		{
			Encryption m = new Encryption();
			m.init();	
			m.Encryption();	
		}
	}

	void init()
	{
		System.out.print("明文：");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			
			Pattern p =Pattern.compile("^[\\w,\\.,=, ]+$"); 
			String str;
			try
			{
				str = bf.readLine();
				Matcher m= p.matcher(str);
				if (m.find())
				{
					plaintext = str.toCharArray();	
					break;
				}
			}
			catch (IOException e)
			{
			}	
			System.out.println("参数错误===============================================================================");
		}
	}

	void Encryption()
	{
		for (int i=0; i < plaintext.length; i++)
		{
			char tmp = plaintext[i];
			
			if (maplist.containsKey(tmp))
				cipherStr.append(maplist.get(tmp));
		}

		System.out.println("密文：" + cipherStr+"\n===============================================================================");
	}

}

	
	
