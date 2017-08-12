package edu.mum.framework.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
@SuppressWarnings("rawtypes")
public class Loader implements LoadMediator {
	
	private static Loader instance = new Loader();
	private String appname = "";
	private boolean windowresizable = false;
	private String loginBGImage = "";
	private String loginBGHeaderImage = "";
	private List<Class> productClasses = new ArrayList<>();;
	
	
	private Loader(){
		loadConfig();
	}
	
	public static Loader getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unused")
	public void loadInit() throws ParserConfigurationException, SAXException, IOException {
		File file = new File("bin/edu/mum/framework/ui/UIConfig.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		
		this.appname = document.getElementsByTagName("appname").item(0).getTextContent();
		this.windowresizable = document.getElementsByTagName("windowresizable").item(0).getTextContent().equals("true") ? true : false;
		this.loginBGImage = document.getElementsByTagName("loginbackground").item(0).getTextContent().isEmpty() ?
				"bin/edu/mum/framework/ui/images/librarybg.jpg" : document.getElementsByTagName("loginbackground").item(0).getTextContent();
		
		this.loginBGHeaderImage = document.getElementsByTagName("headerbackground").item(0).getTextContent().isEmpty() ?
				"bin/edu/mum/framework/ui/images/libraryTitle.jpg" : document.getElementsByTagName("headerbackground").item(0).getTextContent();
		
		try {
			if(document.getElementsByTagName("productclass").getLength() > 0) {
				for(int i = 0 ; i < document.getElementsByTagName("productclass").getLength(); i++) {
					
					if(document.getElementsByTagName("productclass").item(i).getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) document.getElementsByTagName("productclass").item(i);
						productClasses.add(Class.forName("edu.mum.app.domain." + document.getElementsByTagName("productclass").item(i).getTextContent()));
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void loadConfig() {
		// TODO Auto-generated method stub
		try {
			loadInit();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Class> getProductClasses(){
		return productClasses;
	}

	public String getAppname() {
		return appname;
	}
	
	public String getLoginBGImage() {
		return loginBGImage;
	}

	public boolean getWindowResizable(){
		return windowresizable;
	}
	public String getLoginBGHeaderImage() {
		return loginBGHeaderImage;
	}
	
}
