/**
 * 
 */
package com.ciber.springBoot.HolaSpringBoot.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ciber.springBoot.HolaSpringBoot.beans.ClaveValorMongo;
import com.ciber.springBoot.HolaSpringBoot.constants.Constants;
import com.mongodb.DuplicateKeyException;

/**
 * @author ciber
 *
 */
@Configuration
public class PropertiesConfig {

	@Autowired
	@Qualifier(value = "mongoTemplateProperties")
	private MongoTemplate mongoProperties;

	@Autowired
	@Qualifier(value = "myProps")
	Properties props;

	@Bean(name = "myProps")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("application.properties"));
		return bean;

	}

	// METODO PARA GUARDAR EN LA BASE DE DATOS UN APPLICATION.PROPERTIES QUE YA
	// TENEMOS EN EL PROYECTO
//	@PostConstruct
//	public void configProperties() throws IOException {
//		BufferedReader reader;
//		reader = new BufferedReader(new InputStreamReader(new FileInputStream(Paths.get("src/main/resources/application.properties").toFile()), "ISO-8859-1"));
//		String line = reader.readLine();
//		ArrayList<ClaveValorMongo>list=new ArrayList<>();
//		while (line != null) {
//			ClaveValorMongo bean = new ClaveValorMongo();
//			line.replace(" ", "");
//			String[] claveValor = line.split("=");
//			if (claveValor.length < 2) {
//				bean.setKey(claveValor[0]);
//				bean.setValue("");
//			} else {
//				bean.setKey(claveValor[0]);
//				bean.setValue(claveValor[1]);
//			}
//			list.add(bean);
//			line = reader.readLine();
//		}
//		
//		try {
//			mongoProperties.insert(list, "properties");
//		} catch (DuplicateKeyException e) {
//			System.out.println("NO HACEMOS NADA");
//		}
//		
//		reader.close();
//
//	}

	// METODO PARA CARGAR UN APPLICATION.PROPERTIES DESDE MONGO
	@PostConstruct
	public void configProperties() {

		// NOS TRAEMOS LOS DATOS DE MONGO
		ArrayList<ClaveValorMongo> mongoProps = (ArrayList<ClaveValorMongo>) mongoProperties.findAll(ClaveValorMongo.class, "properties");
		// CREAMOS EL FILE Y EL PRINT PARA ESCRIBIR EN EL APPLICATION.PROPERTIES
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Paths.get("src/main/resources/application.properties").toFile()),"ISO-8859-1"));
			for (ClaveValorMongo claveValorMongo : mongoProps) {
				writer.write(claveValorMongo.getKey()+"="+claveValorMongo.getValue()+"\n");
			}
			writer.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	// METODO PARA ORDENAR EL ARRAY DEL PROPERTIES
	private static ArrayList<ClaveValorMongo> Ordenar(ArrayList<ClaveValorMongo> list) {
		String[] keys = Constants.KEYS_PROPERTIES.split(",");
		ArrayList<ClaveValorMongo> listOrdenada = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getKey().startsWith(keys[i])) {
					listOrdenada.add(list.get(j));
					list.remove(j);
				}
			}
		}
		return listOrdenada;

	}

}
