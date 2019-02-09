package com.excel.report;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ReadXl rl=new ReadXl();
    	List<ListsReq> Names=rl.excelData();
    	for (int i = 0; i < Names.size(); i++) {
            System.out.println( Names.get(i).getNames());
		}

    }
}
