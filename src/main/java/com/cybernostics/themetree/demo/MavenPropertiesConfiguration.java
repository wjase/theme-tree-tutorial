package com.cybernostics.themetree.demo;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple class to load maven project properties
 *
 * @author jason
 */
@Configuration
public class MavenPropertiesConfiguration
{

    @Bean
    public Properties mavenProperties()
    {
        java.io.InputStream istream = this.getClass().getClassLoader().getResourceAsStream("maven.properties");
        java.util.Properties p = new Properties();
        try
        {
            p.load(istream);
        } catch (IOException ex)
        {
            Logger.getLogger(MavenPropertiesConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    @Bean
    public String jqueryVersion(@Qualifier("mavenProperties") Properties mavenProperties)
    {
        return mavenProperties.getProperty("jquery.version", "");
    }

    @Bean
    public String bootstrapVersion(@Qualifier("mavenProperties") Properties mavenProperties)
    {
        return mavenProperties.getProperty("bootstrap.version", "");
    }

}
