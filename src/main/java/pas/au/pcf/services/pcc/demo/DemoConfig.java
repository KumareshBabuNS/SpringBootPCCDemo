package pas.au.pcf.services.pcc.demo;

import io.pivotal.spring.cloud.service.gemfire.GemfireServiceConnectorConfig;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.ServiceConnectorConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pas.au.pcf.services.pcc.demo.domain.Employee;

@Configuration
public class DemoConfig extends AbstractCloudConfig
{
    @Bean
    public ServiceConnectorConfig createGemfireConnectorConfig() {

        GemfireServiceConnectorConfig gemfireConfig = new GemfireServiceConnectorConfig();
        gemfireConfig.setPoolSubscriptionEnabled(true);
        gemfireConfig.setPdxSerializer(new ReflectionBasedAutoSerializer(".*"));
        gemfireConfig.setPdxReadSerialized(false);

        return gemfireConfig;
    }

    @Bean(name = "gemfireCache")
    public ClientCache getGemfireClientCache() throws Exception {

        Cloud cloud = new CloudFactory().getCloud();
        ClientCache clientCache = cloud.getSingletonServiceConnector(ClientCache.class,  createGemfireConnectorConfig());

        return clientCache;
    }


    @Bean(name = "employee")
    public Region<String, Employee> employeeRegion(@Autowired ClientCache clientCache) {
        ClientRegionFactory<String, Employee> customerRegionFactory =
                clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);

        Region<String, Employee> employeeRegion = customerRegionFactory.create("employee");

        return employeeRegion;
    }

}
