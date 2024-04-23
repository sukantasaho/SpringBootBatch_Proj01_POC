package com.main.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("biReader")
public class BookItemReader implements ItemReader<String> 
{
    private List<String> bookList = List.of("AA","BB","CC","DD","EE","FF","GG");
    
    int count = 0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		 
		if(count< bookList.size())
		{
			  
			return bookList.get(count++);
			
		}
		return null;
	}

}
