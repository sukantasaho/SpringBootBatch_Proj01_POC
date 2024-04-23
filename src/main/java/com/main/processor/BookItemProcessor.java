package com.main.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("biProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> 
{
      @Override
    public String process(String item) throws Exception 
    {
    	  String bookWithTitle = null;
    	 if(item.equalsIgnoreCase("AA"))
    	  
    		 bookWithTitle = item+" Addedd Title1";
    	  
    	 else if(item.equalsIgnoreCase("BB"))
    	  
    		 bookWithTitle = item+" Addedd Title2";
    	  
    	 else if(item.equalsIgnoreCase("CC"))
    	  
    		 bookWithTitle = item+" Addedd Title3";
    	 
    	 else if(item.equalsIgnoreCase("DD"))
    	  
    		 bookWithTitle = item+" Addedd Title4";
    	  
    	 else if(item.equalsIgnoreCase("EE"))
    	  
    		 bookWithTitle = item+" Addedd Title5";
    	  
    	 else if(item.equalsIgnoreCase("FF"))
    	  
    		 bookWithTitle = item+" Addedd Title6";
    	  
    	 else if(item.equalsIgnoreCase("GG"))
    	  
    		 bookWithTitle = item+" Addedd Title7";
    	  
    	return bookWithTitle;
    }
}
