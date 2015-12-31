package com.mblogger.processor;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.batch.item.ItemProcessor;

import com.mblogger.mapper.FileHeaderMapper;

public class CSVFileProcessor implements ItemProcessor<FileHeaderMapper, String> {

	public String process(FileHeaderMapper arg0) throws Exception {

		// Convert Product into JSON with Jackson
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String toParse = ow.writeValueAsString(arg0);
		
		// Parse JSON with JSON simple
		JSONParser parser = new JSONParser();
		Object object = parser.parse(toParse);
		JSONObject jsonObject = (JSONObject) object;
		
		// Return a JSONObject
		return jsonObject.toJSONString();
	}
}
