package com.example.serialization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCountProgram {
	
	public static void main(String[] args) {

		BufferedReader bfr=null;
		FileReader frdr=null;
		String fileContent="",str="";
		try{
			//Step-1
			frdr=new FileReader("D:\\words.txt");
			bfr=new BufferedReader(frdr);
			
			while((fileContent=bfr.readLine())!=null){
					str=str+fileContent+"\n";
			}
			System.out.println("---------Content from file----------");
			System.out.println(str);
			//remove special chars from string.
			str=str.replaceAll("[-+.:,\n]", " ");
			
			//Step-2
			List<String> wordList=new ArrayList<String>();
			wordList= Arrays.asList(str.split(" "));

			//Step-3
			Map<String,Integer> wordcountmap=new HashMap<String,Integer>();
			Integer count=0;
			//Step-4
			for(String s:wordList){
				if("".equals(s))continue; //skip whitespace
				
				String wordkey=s.toLowerCase();
				if(wordcountmap.containsKey(wordkey)){
					count=wordcountmap.get(wordkey);
					count=count+1;
					wordcountmap.put(wordkey, count);
				}else{
					wordcountmap.put(wordkey, 1);
				}
			}
			
			//Step-5
			List<Map.Entry<String, Integer>> maptolist=new ArrayList<Map.Entry<String,Integer>>(wordcountmap.entrySet());
			
			Collections.sort(maptolist,new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> val1,Entry<String, Integer> val2) {
					if(val1.getValue() < val2.getValue()){
						return 1;//descending order
					}else if(val1.getValue() > val2.getValue()){
						return -1;//descending order
					}
					return 0;
					
				}
			});
			
			//Step-6
			Map<String,Integer> sortedMap=new LinkedHashMap<String,Integer>();
			
			for(Map.Entry<String, Integer> smap:maptolist){
				sortedMap.put(smap.getKey(), smap.getValue());
			}
			//Step-7
			count=0;
			System.out.println("----------------Top 5 repeating words from file---------------------------------------");
			for(Map.Entry<String, Integer> entry:sortedMap.entrySet()){
				System.out.println(entry.getKey()+":"+entry.getValue());
				count++;
				if(count==5)break;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
				bfr.close();
				frdr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
