import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DB {
	private static Connection connection=null;
	private static Statement statement=null;
	
	public static void intializeDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MYSQL DBMS connection provided");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ctis252","root","");
			System.out.println("Database connection is provided");
			
			statement = connection.createStatement();
			System.out.println("Statement object created");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	public static ResultSet executeQ(String sql) {
		ResultSet rs=null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	public static int executeU(String sql) {
		int res=0;
		try {
			res = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static DefaultTableModel showTable(String sql){
		
		//Assume that sql is aselect type of sql statemnt
		DefaultTableModel dtm=null;

		try {
			ResultSet rs = statement.executeQuery(sql);
			if(rs !=null){
				dtm = new DefaultTableModel();
				Vector header = new Vector();
				Vector rows = new Vector();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int numOfFiled = rsmd.getColumnCount();
				for(int i=1; i<=numOfFiled; i++){
					header.add(rsmd.getColumnName(i));
				}
				while(rs.next()){
					Vector  row = new Vector();
					for(int i=1; i<=numOfFiled; i++){						
						row.add(rs.getObject(i));
					}
					rows.add(row);
				}
				
				dtm.setDataVector(rows, header);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtm;
	}
	
	public static Vector<String> getTableNames(){
		
		Vector<String> tablenames=new Vector<String>();
		
		String sql = "show tables";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				tablenames.add(rs.getString(1));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (tablenames);
	}

	public static Vector getCoulumnAt(String sql, int index) {
		Vector<String> typenames=new Vector<String>();		

		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				typenames.add(rs.getString(index));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return (typenames);		
	}
	
	public static DefaultComboBoxModel<String> getColumnAtToFillComboBox(String sql, int index) {		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){					
				dcbm.addElement(rs.getString(index));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (dcbm);		
	}
	
	  private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

	
	public static Double getBtcIndex(){
		URL btcurl = null;
		String index = null;
		JSONObject jo = null;
		JSONArray ja;
	    BufferedReader reader = null;

		try {
			btcurl = new URL("https://api.coinmarketcap.com/v1/ticker/bitcoin/");
			reader = new BufferedReader(new InputStreamReader(btcurl.openStream()));
		    String jsontext = readAll(reader);
		    ja = new JSONArray(jsontext);
jo = ja.getJSONObject(0);
			System.out.println(jo.getDouble("price_usd"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
		
		try {
			return jo.getDouble("price_usd");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Float getBalance(String mail){
		
		String sql = "select * from userbalance where mail ='"+mail+"'";
	    ResultSet res = DB.executeQ(sql);
	    try {
	    	res.next();
		return res.getFloat(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}