/**
 * 
 */
package com.ciber.springBoot.HolaSpringBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ciber
 *
 */
@Configuration
@ConfigurationProperties(prefix="bbdd.url")
public class BbddProperties {
	
	@Value("${bbdd.mongoprueba}")
    private String basePrueba;
	@Value("${bbdd.mongologin}")
    private String usuariosLogin;
    
  
	public String getBasePrueba() {
		return basePrueba;
	}
	public void setBasePrueba(String basePrueba) {
		this.basePrueba = basePrueba;
	}
	public String getUsuariosLogin() {
		return usuariosLogin;
	}
	public void setUsuariosLogin(String usuariosLogin) {
		this.usuariosLogin = usuariosLogin;
	}
	

	@Override
	public String toString() {
		return "BbddProperties [basePrueba=" + basePrueba + ", usuariosLogin=" + usuariosLogin + "]";
	}
}
