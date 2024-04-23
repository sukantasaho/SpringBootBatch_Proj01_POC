package com.main.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("biWriter")
public class BookItemWriter implements ItemWriter<String> 
{
     @Override
    public void write(List<? extends String> chunk) throws Exception 
    {
    	 chunk.forEach(System.out::println);
    	
    }
}
