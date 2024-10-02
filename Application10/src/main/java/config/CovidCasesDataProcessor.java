package config;

import org.springframework.batch.item.ItemProcessor;

import Beans.covidcases;

public class CovidCasesDataProcessor implements ItemProcessor<covidcases,covidcases>{

	@Override
	public covidcases process(covidcases item) throws Exception {
		item.setCountry(item.getCountry().toUpperCase());
		return item;
	}
	

}
