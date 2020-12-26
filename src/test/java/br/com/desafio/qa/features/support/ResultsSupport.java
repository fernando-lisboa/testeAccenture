package br.com.desafio.qa.features.support;

import java.io.IOException;

import br.com.desafio.utils.PropertiesFile;

public class ResultsSupport {

	public static void contador(String resultado) {

		PropertiesFile props;
		try {
			props = new PropertiesFile();
			props.loadProperties();
			if (props.propExiste(resultado)) {
				int total = Integer.getInteger(props.getValor(resultado));
				props.setValor(resultado, Integer.toString(total + 1));
			} else {
				props.setValor(resultado, Integer.toString(1));
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
