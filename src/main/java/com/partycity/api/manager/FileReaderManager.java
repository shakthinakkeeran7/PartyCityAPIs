package com.partycity.api.manager;

import com.partycity.api.dataprovider.ConfigExcelFileReader;
import com.partycity.api.dataprovider.ConfigFileReader;

public class FileReaderManager {

	private FileReaderManager() {
		
	}

	
	public static FileReaderManager getInstance() {
	
		FileReaderManager obj = new FileReaderManager();
			return obj;	
		
	}
	
	public ConfigFileReader getCrInstance() throws Throwable {
		ConfigFileReader cr= new 		ConfigFileReader();
		return cr;
	}
	
	public ConfigExcelFileReader getExcelInstance() throws Throwable {
		ConfigExcelFileReader ce= new ConfigExcelFileReader();
		return ce;
	}
	
	
	
}
