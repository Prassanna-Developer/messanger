package org.prassannas.java.rest.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.prassannas.java.rest.model.MyDate;

/**
 * @author SPrassanna
 *
 */
@Provider
public class MyDateParamConverter implements ParamConverterProvider{

	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType,
			Annotation[] anootations) {
		if(rawType.getName().equals(MyDate.class.getName())){
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar cal = Calendar.getInstance();
					if (value.equals("tommorrow")) {
						cal.add(Calendar.DATE, 1);
					} else if (value.equals("yesterday")) {
						cal.add(Calendar.DATE, -1);
					}
					MyDate myDate = new MyDate();
					myDate.setDate(cal.get(Calendar.DATE));
					myDate.setMonth(cal.get(Calendar.MONTH));
					myDate.setYear(cal.get(Calendar.YEAR));

					return rawType.cast(myDate);
				}

				@Override
				public String toString(T raw) {
					return raw.toString();
				}
				
				
				
				
			};
		}
		return null;
	}

}
