/**
 * Create: 30/12/2019 | Author: Jessé Dantas - Taking 
 */

package br.com.alelo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

//	public static void main(String args[]) {
//		getDateNowPlusDays();
//	}

	public String RandomElement;
	public static String cep;
	public static String cel;
	public static String tel;
	public static String number;
	public static String uf;
	public static String estado;
	public static String cidade;
	public static String bairro;
	public static String endereco;

	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	final static java.util.Random rand = new java.util.Random();
	final static Set<String> identifiers = new HashSet<String>();

	public static String getCep() {
		return cep;
	}

	public static String getCel() {
		return cel;
	}

	public static String getTel() {
		return tel;
	}

	public static String getNumber() {
		return number;
	}

	public static String getUF() {
		return uf;
	}

	public static String getEstado() {
		return estado;
	}

	public static String getCidade() {
		return cidade;
	}

	public static String getBairro() {
		return bairro;
	}

	public static String getEndereco() {
		return endereco;
	}

	public static void setCep(String cep) {
		RandomUtils.cep = cep;
	}

	public static void setCel(String cel) {
		RandomUtils.cel = cel;
	}

	public static void setTel(String tel) {
		RandomUtils.tel = tel;
	}

	public static void setNumber(String number) {
		RandomUtils.number = number;
	}

	public static void setUF(String uf) {
		RandomUtils.uf = uf;
	}

	public static void setEstado(String estado) {
		RandomUtils.estado = estado;
	}

	public static void setCidade(String cidade) {
		RandomUtils.cidade = cidade;
	}

	public static void setBairro(String bairro) {
		RandomUtils.bairro = bairro;
	}

	public static void setEndereco(String endereco) {
		RandomUtils.endereco = endereco;
	}

	public String getRandomCep() {
		Random randomCep = new Random();
		String[] getCep = { "04551060", "06455030", "22041012", "24230052", "30570410", "37701391" };
		int index = randomCep.nextInt(getCep.length);
		cep = getCep[index];
		System.out.println("getRandomCep() => " + cep);
		return cep;
	}

	public String getRandomEndereco() {
		switch (getRandomCep()) {
		case "04551060":
			endereco = "Rua Funchal";
			break;
		case "06455030":
			endereco = "Alameda Xingu";
			break;
		case "22041012":
			endereco = "Rua Tonelero";
			break;
		case "24230052":
			endereco = "Rua Belisário Augusto";
			break;
		case "30570410":
			endereco = "Rua Cipreste";
			break;
		case "37701391":
			endereco = "Av. Champagnat";
			break;

		default:
			System.out.println("< Cep > não encontrado(a) no método getRandomEndereco()");
		}
		if (endereco != null) {
			System.out.println("getRandomEndereco() => " + endereco);
		}
		return endereco;
	}

	public String getRandomBairro() {
		switch (getRandomEndereco()) {
		case "Rua Funchal":
			bairro = "Vila Olimpia";
			break;
		case "Alameda Xingu":
			bairro = "Alphaville";
			break;
		case "Rua Tonelero":
			bairro = "Copacabana";
			break;
		case "Rua Belisário Augusto":
			bairro = "Icaraí";
			break;
		case "Rua Cipreste":
			bairro = "Marajó";
			break;
		case "Av. Champagnat":
			bairro = "São Domingos";
			break;

		default:
			System.out.println("< Endereco > não encontrado(a) no método getRandomBairro()");
		}
		if (bairro != null) {
			System.out.println("getRandomBairro() => " + bairro);
		}
		return bairro;
	}

	public String getRandomCidade() {
		switch (getRandomBairro()) {
		case "Vila Olimpia":
			cidade = "São Paulo";
			break;
		case "Alphaville":
			cidade = "Barueri";
			break;
		case "Copacabana":
			cidade = "Rio de Janeiro";
			break;
		case "Icaraí":
			cidade = "Niterói";
			break;
		case "Marajó":
			cidade = "Belo Horizonte";
			break;
		case "São Domingos":
			cidade = "Poços de Caldas";
			break;

		default:
			System.out.println("< Estado > não encontrado(a) no método getRandomCidade()");

		}
		if (cidade != null) {
			System.out.println("getRandomCidade() => " + cidade);
		}
		return cidade;
	}

	public String getRandomEstado() {
		switch (getRandomCidade()) {
		case "Barueri":
		case "São Paulo":
			estado = "São Paulo";
			break;
		case "Rio de Janeiro":
		case "Niterói":
			estado = "Rio de Janeiro";
			break;
		case "Belo Horizonte":
		case "Poços de Caldas":
			estado = "Minas Gerais";
			break;

		default:
			System.out.println("< Cidade > não encontrado(a) no método getRandomEstado()");

		}
		if (estado != null) {
			System.out.println("getRandomEstado() => " + estado);
		}
		return estado;
	}

	public String getRandomUF() {
		switch (getRandomEstado()) {
		case "São Paulo":
			uf = "SP";
			break;
		case "Rio de Janeiro":
			uf = "RJ";
			break;
		case "Minas Gerais":
			uf = "MG";
			break;

		default:
			System.out.println("< Estado > não encontrado(a) no método getRandomUF()");

		}
		if (uf != null) {
			System.out.println("getRandomUF() => " + uf);
		}
		return uf;
	}

	public String getGenericCidade() {
		Random randomCidade = new Random();

		switch (getRandomEstado()) {
		case "São Paulo":
			String[] getCidadeSP = { "São Paulo", "Barueri" };
			int indexSP = randomCidade.nextInt(getCidadeSP.length);
			cidade = getCidadeSP[indexSP];
			break;
		case "Rio de Janeiro":
			String[] getCidadeRJ = { "Rio de Janeiro", "Niterói" };
			int indexRJ = randomCidade.nextInt(getCidadeRJ.length);
			cidade = getCidadeRJ[indexRJ];
			break;
		case "Mina Gerais":
			String[] getCidadeMG = { "Belo Horizonte", "Poços de Caldas" };
			int indexMG = randomCidade.nextInt(getCidadeMG.length);
			cidade = getCidadeMG[indexMG];
			break;

		default:
			System.out.println("< Estado > não encontrado(a) no método getRandomCidade()");

		}
		if (cidade != null) {
			System.out.println("getRandomCidade() => " + cidade);
		}
		return cidade;
	}

	public String getGenericUF() {
		Random randomUF = new Random();
		String[] getUF = { "SP", "RJ", "MG" };
		int index = randomUF.nextInt(getUF.length);
		uf = getUF[index];
		System.out.println("getRandomUF() => " + uf);
		return uf;
	}

	public String getGenericEstado() {
		Random randomEstado = new Random();
		String[] getEstado = { "São Paulo", "Rio de Janeiro", "Minas Gerais" };
		int index = randomEstado.nextInt(getEstado.length);
		estado = getEstado[index];
		System.out.println("getRandomEstado() => " + estado);
		return estado;
	}

	public String getGenericBairro() {
		switch (getRandomCidade()) {
		case "São Paulo":
			bairro = "Vila Olimpia";
			break;
		case "Barueri":
			bairro = "Alphaville";
			break;
		case "Rio de Janeiro":
			bairro = "Copacabana";
			break;
		case "Niterói":
			bairro = "Icaraí";
			break;
		case "Belo Horizonte":
			bairro = "Marajó";
			break;
		case "Poços de Caldas":
			bairro = "São Domingos";
			break;

		default:
			System.out.println("< Cidade > não encontrado(a) no método getRandomBairro()");
		}
		if (bairro != null) {
			System.out.println("getRandomBairro() => " + bairro);
		}
		return bairro;
	}

	public String getGenericEndereco() {
		switch (getRandomBairro()) {
		case "Vila Olimpia":
			endereco = "Rua Funchal"; // CEP: 04551-060
			break;
		case "Alphaville":
			endereco = "Alameda Xingu";// CEP: 06455-030
			break;
		case "Copacabana":
			endereco = "Rua Tonelero"; // CEP: 22041-012
			break;
		case "Icaraí":
			endereco = "Rua Belisário Augusto"; // CEP: 24230-052
			break;
		case "Marajó":
			endereco = "Rua Cipreste"; // CEP: 30570-410
			break;
		case "São Domingos":
			endereco = "Av. Champagnat"; // CEP: 37701-391
			break;

		default:
			System.out.println("< Bairro > não encontrado(a) no método getRandomEndereco()");
		}
		if (endereco != null) {
			System.out.println("getRandomEndereco() => " + endereco);
		}
		return endereco;
	}

	public String getGenericCep() {
		Random randomCep = new Random();
		int getCep = randomCep.nextInt(99999999);
		cep = Integer.toString(getCep);
		System.out.println("getGenericCep() => " + cep);
		return cep;
	}

	public String getGenericTelefone() {
		Random randomTel = new Random();
		int getTel = randomTel.nextInt(69999999);
		tel = Integer.toString(getTel);
		System.out.println("Tel: " + tel);
		return tel;
	}

	public String getGenericCelular() {
		Random randomCel = new Random();
		int getCel = randomCel.nextInt(99999999);
		cel = "9" + Integer.toString(getCel);
		System.out.println("Cel: " + cel);
		return cel;
	}

	public String getGenericNumber() {
		Random randomNumber = new Random();
		int getNumber = randomNumber.nextInt(9999);
		number = Integer.toString(getNumber);
		System.out.println("Number: " + number);
		return number;
	}

	public String getGenericDay() {
		LocalDate from = LocalDate.of(1900, 1, 1);
		LocalDate to = LocalDate.of(2000, 1, 1);
		long days = from.until(to, ChronoUnit.DAYS);
		long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
		LocalDate randomDate = from.plusDays(randomDays);
		String outDate = randomDate.format(DateTimeFormatter.ofPattern("dd"));
		System.out.println("Dia: " + outDate);
		return outDate;
	}

	public String getGenericMonth() {
		LocalDate from = LocalDate.of(1900, 1, 1);
		LocalDate to = LocalDate.of(2000, 1, 1);
		long month = from.until(to, ChronoUnit.DAYS);
		long randomDays = ThreadLocalRandom.current().nextLong(month + 1);
		LocalDate randomMonth = from.plusDays(randomDays);
		String outDate = randomMonth.format(DateTimeFormatter.ofPattern("MM"));
		System.out.println("Mês: " + outDate);
		return outDate;
	}

	public String getGenericYear() {
		LocalDate from = LocalDate.of(1900, 1, 1);
		LocalDate to = LocalDate.of(2000, 1, 1);
		long year = from.until(to, ChronoUnit.DAYS);
		long randomYear = ThreadLocalRandom.current().nextLong(year + 1);
		LocalDate randomDate = from.plusDays(randomYear);
		String outDate = randomDate.format(DateTimeFormatter.ofPattern("yyyy"));
		System.out.println("Ano: " + outDate);
		return outDate;
	}

	public String getGenericDate() {
		LocalDate from = LocalDate.of(1900, 1, 1);
		LocalDate to = LocalDate.of(2000, 1, 1);
		long days = from.until(to, ChronoUnit.DAYS);
		long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
		LocalDate randomDate = from.plusDays(randomDays);
		String outDate = randomDate.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		System.out.println("Data: " + outDate);
		return outDate;
	}

	public LocalDate getDateNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		return localDate;
	}

	public LocalDate getDateNowPlusDays(int otherDay) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate localDate = LocalDate.now();
		LocalDate otherDate = localDate.plusDays(otherDay);
		System.out.println(dtf.format(localDate));
		System.out.println(dtf.format(otherDate));
		return otherDate;
	}

	public String getGenericAlphanumeric() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 7;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		System.out.println("Alphanumeric: " + builder);
		return builder.toString();
	}

}
