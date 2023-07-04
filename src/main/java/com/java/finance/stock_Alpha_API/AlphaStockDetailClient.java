package com.java.finance.stock_Alpha_API;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AlphaStockDetailClient {
	public static void main(String[] args) {
		try {

			String[] stock_List=new String[] {
					"NKE",
					"NOC",
					"NOW",
					"NRG",
					"NSC",
					"NTAP"
}; 

			for (int i = 0; i < stock_List.length; i++) {

				//String urls = "https://www.alphavantage.co/query?function=OVERVIEW&symbol="+stock_List[i]+"&apikey=50M3AP1K3Y";
				String urls = "https://www.alphavantage.co/query?function=OVERVIEW&symbol="+stock_List[i]+"&apikey=X8N115V4N6A1QCIG";
                System.out.println("urls:" +urls);
				@SuppressWarnings("deprecation")
				URL url = new URL(urls);

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();

				//Getting the response code
				int responsecode = conn.getResponseCode();

				if (responsecode != 200) {
					throw new RuntimeException("HttpResponseCode: " +responsecode);
				} else {

					String inline = "";
					Scanner scanner = new Scanner(url.openStream());

					//Write all the JSON data into a string using a scanner
					while (scanner.hasNext()) {
						inline += scanner.nextLine();
					}


					//Close the scanner
					scanner.close();
					// System.out.println("inline" +inline);
					//Using the JSON simple library parse the string into a json object
					JSONParser parse = new JSONParser();
					JSONObject data_obj = (JSONObject) parse.parse(inline);

					
					//DB connection
					Connection con = DBConnectionManager.ConnectToDB();

					PreparedStatement pstmt = con.prepareStatement("INSERT INTO StockBasicDetails values (?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)");
					//for(Object object : data_obj) {
					JSONObject record = (JSONObject) data_obj;
					//int id = Integer.parseInt((String) record.get("ID"));
					String Symbol = (String) record.get("Symbol");
					String AssetType = (String) record.get("AssetType");
					String StockName = (String) record.get("Name");
					String StockDescription = (String) record.get("Description");
					String Exchange = (String) record.get("Exchange");
					String Currency = (String) record.get("Currency");
					String Country = (String) record.get("Country");
					String Sector = (String) record.get("Sector");
					String Industry = (String) record.get("Industry");
					String MarketCapitalization = (String) record.get("MarketCapitalization");
					String EBITDA = (String) record.get("EBITDA");
					String PERatio = (String) record.get("PERatio");
					String PEGRatio = (String) record.get("PEGRatio");
					String BookValue = (String) record.get("BookValue");
					String DividendPerShare = (String) record.get("DividendPerShare");
					String DividendYield = (String) record.get("DividendYield");
					String EPS = (String) record.get("EPS");
					String RevenuePerShareTTM = (String) record.get("RevenuePerShareTTM");
					String ProfitMargin = (String) record.get("ProfitMargin");
					String OperatingMarginTTM = (String) record.get("OperatingMarginTTM");
					String ReturnOnAssetsTTM = (String) record.get("ReturnOnAssetsTTM");
					String ReturnOnEquityTTM = (String) record.get("ReturnOnEquityTTM");
					String RevenueTTM = (String) record.get("RevenueTTM");
					String GrossProfitTTM = (String) record.get("GrossProfitTTM");
					String DilutedEPSTTM = (String) record.get("DilutedEPSTTM");
					String QuarterlyEarningsGrowthYOY = (String) record.get("QuarterlyEarningsGrowthYOY");
					String QuarterlyRevenueGrowthYOY = (String) record.get("QuarterlyRevenueGrowthYOY");
					String AnalystTargetPrice = (String) record.get("AnalystTargetPrice");
					String TrailingPE = (String) record.get("TrailingPE");
					String ForwardPE = (String) record.get("ForwardPE");
					String PriceToSalesRatioTTM = (String) record.get("PriceToSalesRatioTTM");
					String PriceToBookRatio = (String) record.get("PriceToBookRatio");
					String EVToRevenue = (String) record.get("EVToRevenue");
					String EVToEBITDA = (String) record.get("EVToEBITDA");
					String M_52WeekHigh = (String) record.get("52WeekHigh");
					String M_52WeekLow = (String) record.get("52WeekLow");
					String M_50DayMovingAverage = (String) record.get("50DayMovingAverage");
					String M_200DayMovingAverage = (String) record.get("200DayMovingAverage");





					pstmt.setString(1, Symbol);
					pstmt.setString(2, AssetType);
					pstmt.setString(3, StockName);
					pstmt.setString(4, StockDescription);
					pstmt.setString(5, Exchange);

					pstmt.setString(6, Currency);
					pstmt.setString(7, Country);
					pstmt.setString(8, Sector);
					pstmt.setString(9, Industry);
					pstmt.setString(10, MarketCapitalization);

					pstmt.setString(11, EBITDA);
					pstmt.setString(12, PERatio);
					pstmt.setString(13, PEGRatio);
					pstmt.setString(14, BookValue);
					pstmt.setString(15, DividendPerShare);

					pstmt.setString(16, DividendYield);
					pstmt.setString(17, EPS);
					pstmt.setString(18, RevenuePerShareTTM);
					pstmt.setString(19, ProfitMargin);
					pstmt.setString(20, OperatingMarginTTM);

					pstmt.setString(21, ReturnOnAssetsTTM);
					pstmt.setString(22, ReturnOnEquityTTM);
					pstmt.setString(23, RevenueTTM);
					pstmt.setString(24, GrossProfitTTM);
					pstmt.setString(25, DilutedEPSTTM);

					pstmt.setString(26, QuarterlyEarningsGrowthYOY);
					pstmt.setString(27, QuarterlyRevenueGrowthYOY);
					pstmt.setString(28, AnalystTargetPrice);
					pstmt.setString(29, TrailingPE);
					pstmt.setString(30, ForwardPE);

					pstmt.setString(31, PriceToSalesRatioTTM);
					pstmt.setString(32, PriceToBookRatio);
					pstmt.setString(33, EVToRevenue);
					pstmt.setString(34, EVToEBITDA);
					pstmt.setString(35, M_52WeekHigh);

					pstmt.setString(36, M_52WeekLow);
					pstmt.setString(37, M_50DayMovingAverage);
					pstmt.setString(38, M_200DayMovingAverage);


					pstmt.executeUpdate();

					System.out.println("Records inserted.....");
				}
			}	
		}            

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


