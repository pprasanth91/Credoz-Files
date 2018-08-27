package com.day08;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class File_Ex {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//folderCreation();
	//	getFileCount();
		 fileReaderWritter();
		//bufferedReaderWritter();
		//printWritter();
	//inputStream();
		//scannerReader();

	}
	
	public static void folderCreation() throws Exception {
		File oDir = new File("E:\\Selenium\\Credoz Code\\File");
		if(oDir.exists()) {
			System.out.println("Folder Already Exist");
		}else {
			System.out.println("Folder  Not Exist, So Creating new Folder");
			oDir.mkdirs();
		}
		
		File oFile = new File(oDir, "NewFile.xls");
		if(oFile.exists()) {
			System.out.println("File is Existing");
		}else {
			System.out.println("File is not Existing, So Creating the new File");
			oFile.createNewFile();
		}
	}
	
	public static void fileReaderWritter() throws Exception {
		File oDir = new File("E:\\\\Selenium\\\\Credoz Code\\\\File");
		if(oDir.exists()) {
			System.out.println("Folder Already Exist");
		}else {
			System.out.println("Folder  Not Exist, So Creating new Folder");
			oDir.mkdirs();
		}
		
		File oFile = new File(oDir, "FileReaderWritter.txt");
		if(oFile.exists()) {
			System.out.println("File is Existing");
		}else {
			System.out.println("File is not Existing, So Creating the new File");
			oFile.createNewFile();
		}
		
		FileWriter oWrite = new FileWriter(oFile, true);//true overwrite, false fresh
		oWrite.write("This is Java Session. \n");
		oWrite.write(65+"\n");
		oWrite.write("Followed By Selenium Session");
		oWrite.flush();
		oWrite.close();
		
		FileReader oRead = new FileReader(oFile);
		int iRead = oRead.read();
		while(iRead!=-1) {
			System.out.print((char)iRead);
			iRead = oRead.read();
		}
		oRead.close();
	}
	
	public static void bufferedReaderWritter() throws Exception {
		File oDir = new File("E:\\Selenium\\Credoz Code\\File");
		if(oDir.exists()) {
			System.out.println("Folder Already Exist");
		}else {
			System.out.println("Folder  Not Exist, So Creating new Folder");
			oDir.mkdirs();
		}
		
		File oFile = new File(oDir, "BufferedReaderWritter.txt");
		if(oFile.exists()) {
			System.out.println("File is Existing");
		}else {
			System.out.println("File is not Existing, So Creating the new File");
			oFile.createNewFile();
		}
		
		FileWriter oWrite = new FileWriter(oFile, true);
		BufferedWriter oBWrite = new BufferedWriter(oWrite);
		oBWrite.write("This is Java Session.");
		oBWrite.newLine();
		oBWrite.write("Followed By Selenium Session.");
		oBWrite.newLine();
		oBWrite.write(65);
		oBWrite.flush();
		oBWrite.close();
		
		FileReader oRead = new FileReader(oFile);
		BufferedReader oBRead = new BufferedReader(oRead);
		String sLine = oBRead.readLine();
		while(sLine!=null) {
			System.out.println(sLine);
			sLine = oBRead.readLine();
		}
		oBRead.close();
	}
	
	public static void printWritter() throws Exception {
		File oDir = new File("E:\\Selenium\\Credoz Code\\File");
		if(oDir.exists()) {
			System.out.println("Folder Already Exist");
		}else {
			System.out.println("Folder  Not Exist, So Creating new Folder");
			oDir.mkdirs();
		}
		
		File oFile = new File(oDir, "PrintWritter.txt");
		if(oFile.exists()) {
			System.out.println("File is Existing");
		}else {
			System.out.println("File is not Existing, So Creating the new File");
			oFile.createNewFile();
		}
		
		FileWriter oWrite = new FileWriter(oFile, true);
		PrintWriter oPWrite = new PrintWriter(oWrite);
		oPWrite.println("This is Java Session");
		oPWrite.println(100);
		oPWrite.println(10.5);
		oPWrite.println(true);
		oPWrite.println("Followed By Selenium Session");
		oPWrite.flush();
		oPWrite.close();
		
		FileReader oRead = new FileReader(oFile);
		BufferedReader oBRead = new BufferedReader(oRead);
		String sLine = oBRead.readLine();
		while(sLine!=null) {
			System.out.println(sLine);
			sLine = oBRead.readLine();
		}
		oBRead.close();
	}
	
	public static void inputStream() throws Exception {
		//FileInputStream oRead = new FileInputStream(System.in);
		InputStreamReader oRead = new InputStreamReader(System.in);
		BufferedReader oBRead = new BufferedReader(oRead);
		System.out.println("Enter the Course  Name : ");
		String sName = oBRead.readLine();
		System.out.println("Name is : "+sName);
		System.out.println("Enter the Duration : ");
		String iDuration = oBRead.readLine();
		int iDuration1 = oRead.read();
		System.out.println("Duration is : "+iDuration);
		oBRead.close();
	}
	
	public static void scannerReader() {
		Scanner oScan = new Scanner(System.in);
		System.out.println("Enter the Course  Name : ");
		String sName = oScan.nextLine();
		System.out.println("Name is : "+sName);
		System.out.println("Enter the Duration : ");
		int iDuration = oScan.nextInt();
		System.out.println("Duration is : "+iDuration);
		oScan.close();
		
	}
	
	public static void getFileCount() {
		File oFolder = new File("C:\\Users\\admin\\Downloads");
		String sFolder[] = oFolder.list();
		int iCount=0;
		for(int i=0;i<sFolder.length;i++) {
			System.out.println(sFolder[i]);
			if(sFolder[i].contains("EXE"))
				iCount++;
		}
		
		System.out.println("EXE File Count is : "+iCount);
	}

}










