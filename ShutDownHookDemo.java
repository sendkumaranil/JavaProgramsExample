package com.example.serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class ShutDownHookDemo {

	public static String status = "STOPPED";
	public static String fileName = "";

	public static void main(String[] args) {
		String directory = "D:\\AnilK\\MyDocs";
		Runtime.getRuntime().addShutdownHook(new ProcessorHook());
		File dir = new File(directory);

		File[] txtFiles = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".txt"))
					return true;
				else
					return false;
			}
		});
		
		//All txt files found at this directory
		for (File file : txtFiles)
		{
			System.out.println(file.getName());
		}
		
		for (File file : txtFiles) {
			System.out.println("Currently Precessing File:"+file.getName());
			BufferedReader reader = null;
			status = "STARTED";
			fileName = file.getName();
			try {
				FileReader fr = new FileReader(file);
				reader = new BufferedReader(fr);
				String line;

				line = reader.readLine();
				int count=0;
				while (line != null) {
					System.out.println(line);
					Thread.sleep(1000); // assuming it takes 1 second to process each record
					// read next line
					line = reader.readLine();
					count++;
					
					if(count==10){
						System.exit(0); //application closed abnormally here
					}
				}
				status = "PROCESSED";
			} catch (IOException | InterruptedException e) {
				status = "ERROR";
				e.printStackTrace();
			}finally{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		status="FINISHED";
	}
}
class ProcessorHook extends Thread {

	@Override
	public void run(){
		System.out.println("Status="+ShutDownHookDemo.status);
		System.out.println("FileName="+ShutDownHookDemo.fileName);
		if(!ShutDownHookDemo.status.equals("FINISHED")){
			System.err.println("Seems some error, while processing file sending alert...");
			//manage sending alert here thru email or logg.
		}
		
	}
}
