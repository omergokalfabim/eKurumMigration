package com.uniyaz.sistem.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
import org.jboss.logging.Logger;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("com.uniyaz.sistem.util.MyDateConverter")
public class MyDateConverter implements Converter<Object> {

	private static final Logger LOG = Logger.getLogger(MyDateConverter.class);
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(component.getAttributes().get("pattern").toString());
		Date result;
		try {
			result = df.parse(value);
			return new Timestamp(result.getTime());
		} catch (ParseException e) {
			LOG.debug(e.getMessage(),e);
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		return new SimpleDateFormat(component.getAttributes().get("pattern").toString()).format(value);
	}

}

